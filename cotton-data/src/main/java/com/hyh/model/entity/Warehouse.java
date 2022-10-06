package com.hyh.model.entity;

import com.common.entity.BaseEntity;
import lombok.Getter;

/**
 * 仓库
 * @author hyh
 * @date 2022/10/4 14:39
 */
@Getter
public class Warehouse extends BaseEntity {

    public Warehouse(String code, double totalCapacity, boolean idle, double remainingCapacity, String location) {
        this.code = code;
        this.totalCapacity = totalCapacity;
        this.idle = idle;
        this.remainingCapacity = remainingCapacity;
        this.location = location;
    }

    /**
     * 编号
     */
    private String code;

    /**
     * 总容量
     */
    private double totalCapacity;

    /**
     * 使用状态(空闲)
     */
    private boolean idle;

    /**
     * 当前剩余容量
     */
    private double remainingCapacity;

    /**
     * 位置(以坐标形式存储)
     */
    private String location;


    public void reduceRemainingCapacity(double weight){
        this.remainingCapacity-=weight;
    }

    public void increaseRemainingCapacity(double weight){
        this.remainingCapacity+=weight;
    }

}
