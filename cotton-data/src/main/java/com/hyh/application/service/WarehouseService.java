package com.hyh.application.service;

import com.hyh.application.dto.WarehouseInput;
import com.hyh.model.entity.Warehouse;
import com.hyh.model.mapper.WarehouseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 仓库业务
 * @author hyh
 * @date 2022/10/4 21:57
 */
@Service
@RequiredArgsConstructor
public class WarehouseService {

    private final WarehouseMapper warehouseMapper;

    public boolean create(WarehouseInput input){
        return warehouseMapper.save(input.mapTo());
    }

    public Warehouse getById(String id){
        return warehouseMapper.getById(id);
    }

    public boolean delById(String id){
        return warehouseMapper.delById(id);
    }

    public List<Warehouse> getAll(){
        return warehouseMapper.getAll();
    }

    public List<Warehouse> getByCotton(WarehouseInput input){
        return warehouseMapper.getByWarehouse(input.mapTo());
    }
}
