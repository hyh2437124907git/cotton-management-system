package com.hyh.application.dto;

import com.hyh.model.entity.Warehouse;
import lombok.AllArgsConstructor;

/**
 * @author hyh
 * @date 2022/10/4 21:59
 */
@AllArgsConstructor
public class WarehouseInput {

    /**
     * 编号
     */
    private String code;

    /**
     * 总容量
     */
    private double totalCapacity;


    /**
     * 位置(以坐标形式存储)
     */
    private String location;

    public Warehouse mapTo(){
        return new Warehouse(code, totalCapacity, true, totalCapacity, location);
    }
}
