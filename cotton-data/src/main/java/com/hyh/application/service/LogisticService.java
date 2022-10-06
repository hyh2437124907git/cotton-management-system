package com.hyh.application.service;

import com.common.exception.ServiceException;
import com.hyh.application.dto.LogisticInput;
import com.hyh.model.entity.Cotton;
import com.hyh.model.entity.Logistic;
import com.hyh.model.entity.StorageData;
import com.hyh.model.entity.Warehouse;
import com.hyh.model.entity.enums.Direction;
import com.hyh.model.mapper.CottonMapper;
import com.hyh.model.mapper.LogisticMapper;
import com.hyh.model.mapper.StorageDataMapper;
import com.hyh.model.mapper.WarehouseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 物流业务（出入库）
 *
 * @author hyh
 * @date 2022/10/4 22:07
 */
@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class LogisticService {

    private final LogisticMapper logisticMapper;

    private final StorageDataMapper storageDataMapper;

    private final WarehouseMapper warehouseMapper;

    private final CottonMapper cottonMapper;

    /**
     * 新增物流
     */
    public boolean addLogistic(LogisticInput input) {
        Logistic logistic;
        Warehouse warehouse = warehouseMapper.getById(input.getWarehouseId());
        Cotton cotton = cottonMapper.getById(input.getCottonId());
        StorageData storageData = checkAndCreateStorageData(input, warehouse, cotton);
        logistic = input.mapTo(storageData);
        warehouseMapper.updateRemainingCapacity(warehouse.getRemainingCapacity());
        return logisticMapper.save(logistic);
    }

    private StorageData checkAndCreateStorageData(LogisticInput input, Warehouse warehouse, Cotton cotton) {
        StorageData storageData = storageDataMapper.getByWarehouseIdAndCottonId(input.getWarehouseId(), input.getCottonId());
        if (storageData != null) {
            updateStorage(input, warehouse, storageData);
        } else {
            //第一次存该组合的数据
            storageData = saveStorage(input,warehouse,cotton);
        }
        return storageData;
    }

    private void updateStorage(LogisticInput input, Warehouse warehouse, StorageData storageData){
        if (input.getDirection().equals(Direction.in_storage)) {
            checkInStorage(input, warehouse);
            syncInStorage(input, storageData, warehouse);
        } else {
            checkOutStorage(input, storageData);
            syncOutStorage(input, storageData, warehouse);
        }
        storageDataMapper.updateWeight(storageData);
    }

    private StorageData saveStorage(LogisticInput input, Warehouse warehouse,Cotton cotton){
        //第一次存该组合的数据
        StorageData storageData = new StorageData(warehouse, cotton, 0);
        if (input.getDirection().equals(Direction.in_storage)) {
            checkInStorage(input, warehouse);
            syncInStorage(input, storageData, warehouse);
        } else {
            throw new ServiceException("当前仓储库中暂无指定仓库和棉花的数据，无法出库!");
        }
        storageDataMapper.save(storageData);
        return storageData;
    }

    /**
     * 入库数据同步
     */
    private void syncInStorage(LogisticInput input, StorageData storageData, Warehouse warehouse) {
        //增加仓储数据
        storageData.increaseWeight(input.getWeight());
        //减少仓库剩余容量
        warehouse.reduceRemainingCapacity(input.getWeight());
    }

    private void syncOutStorage(LogisticInput input, StorageData storageData, Warehouse warehouse) {
        //减少仓储数据
        storageData.reduceWeight(input.getWeight());
        //增加仓库剩余容量
        warehouse.increaseRemainingCapacity(input.getWeight());
    }

    private void checkInStorage(LogisticInput input, Warehouse warehouse) {
        if (warehouse.getRemainingCapacity() < input.getWeight()) {
            throw new ServiceException("该仓库的容量仅剩" + warehouse.getRemainingCapacity() + "不足以存放!");
        }
    }

    private void checkOutStorage(LogisticInput input, StorageData storageData) {
        if (storageData.getWeight() < input.getWeight()) {
            throw new ServiceException("仓库库存不足!");
        }
    }

}
