package com.hyh;

import com.common.support.IdWorkerUtil;
import com.hyh.application.dto.LogisticInput;
import com.hyh.model.entity.Cotton;
import com.hyh.model.entity.Logistic;
import com.hyh.model.entity.StorageData;
import com.hyh.model.entity.Warehouse;
import com.hyh.model.entity.enums.Color;
import com.hyh.model.entity.enums.Direction;
import com.hyh.model.entity.enums.Rank;
import com.hyh.model.mapper.CottonMapper;
import com.hyh.model.mapper.LogisticMapper;
import com.hyh.model.mapper.StorageDataMapper;
import com.hyh.model.mapper.WarehouseMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author hyh
 * @date 2022/10/3 19:06
 */
@SpringBootTest
@MapperScan("com.hyh.model.mapper")
public class CottonDataApplicationTest {

    @Autowired
    private CottonMapper cottonMapper;

    @Autowired
    private WarehouseMapper warehouseMapper;

    @Autowired
    private LogisticMapper logisticMapper;

    @Autowired
    private StorageDataMapper storageDataMapper;

    @Test
    public void cottonTest() {
        System.out.println("----------------------------");
        saveCotton();
    }

    @Test
    public void WareHouseTest() {
        saveWareHouse();
    }

    @Test
    public void LogisticTest() {
        Cotton cotton = cottonMapper.getById("629403119872114688");
        Warehouse warehouse = warehouseMapper.getById("629722293693579264");
        LogisticInput logisticInput = new LogisticInput(Direction.out_storage, warehouse.getId(), cotton.getId(), 700);
        StorageData storageData = storageDataMapper.getByWarehouseIdAndCottonId(warehouse.getId(), cotton.getId());
        Logistic logistic;
        if(storageData!=null){
            logistic = logisticInput.mapTo(storageData);
            if(logisticInput.getDirection().equals(Direction.in_storage)){
                if(warehouse.getRemainingCapacity()<logistic.getWeight()){
                    throw new RuntimeException("该仓库的容量仅剩"+warehouse.getRemainingCapacity()+"不足以存放!");
                }
                storageData.increaseWeight(logistic.getWeight());
                warehouse.reduceRemainingCapacity(logistic.getWeight());
            }else {
                if(storageData.getWeight()<logistic.getWeight()){
                    throw new RuntimeException("仓库库存不足!");
                }
                storageData.reduceWeight(logistic.getWeight());
                warehouse.increaseRemainingCapacity(logistic.getWeight());
            }
            storageDataMapper.updateWeight(storageData);
            warehouseMapper.updateRemainingCapacity(warehouse.getRemainingCapacity());
        }else {
            storageData = new StorageData(warehouseMapper.getById(logisticInput.getWarehouseId()), cottonMapper.getById(logisticInput.getCottonId()), logisticInput.getWeight());
            storageDataMapper.save(storageData);
            logistic = logisticInput.mapTo(storageData);
        }
        logisticMapper.save(logistic);
    }

    private void saveCotton() {
        Cotton cotton = new Cotton("品种4", Color.LIGHT_YELLOW, Rank.Level_3, "哈尔滨");
        cottonMapper.save(cotton);
    }

    private void saveWareHouse() {
        Warehouse warehouse = new Warehouse("001", 10000.0, true, 10000.0, "(81.2, 96.73)");
        warehouseMapper.save(warehouse);
    }

    public static void main(String[] args) {
        long nextId = IdWorkerUtil.getNextId();
        System.out.println(nextId);
    }

    private Cotton getCottonById(String id) {
        return cottonMapper.getById(id);
    }

    private List<Cotton> getAll() {
        return cottonMapper.getAll();
    }

}
