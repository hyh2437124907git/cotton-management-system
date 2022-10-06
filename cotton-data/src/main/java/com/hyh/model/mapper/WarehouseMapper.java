package com.hyh.model.mapper;

import com.hyh.model.mapper.base.MyBaseMapper;
import com.hyh.model.entity.Warehouse;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hyh
 * @date 2022/10/4 16:26
 */
@Repository
public interface WarehouseMapper extends MyBaseMapper<Warehouse> {

    /**
     * 获取指定id的仓库
     *
     * @param id 仓库Id
     * @return 仓库数据
     */
    Warehouse getById(String id);

    /**
     * 删除指定id的仓库
     *
     * @param id 仓库Id
     */
    boolean delById(String id);

    /**
     * 获取所有仓库信息
     *
     * @return 所有仓库数据
     */
    List<Warehouse> getAll();

    void updateRemainingCapacity(double remainingCapacity);

    /**
     * todo 暂时没有实现sql
     */
    List<Warehouse> getByWarehouse(Warehouse warehouse);
}
