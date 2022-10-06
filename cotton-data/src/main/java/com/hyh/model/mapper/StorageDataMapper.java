package com.hyh.model.mapper;

import com.hyh.model.mapper.base.MyBaseMapper;
import com.hyh.model.entity.StorageData;
import org.springframework.stereotype.Repository;

/**
 * @author hyh
 * @date 2022/10/4 16:28
 */
@Repository
public interface StorageDataMapper extends MyBaseMapper<StorageData> {

    /**
     * 根据仓库id和棉花id获取存储数据
     * @param warehouseId 仓库id
     * @param cottonId 棉花id
     * @return 存储数据
     */
    StorageData getByWarehouseIdAndCottonId(String warehouseId, String cottonId);

    void updateWeight(StorageData storageData);
}
