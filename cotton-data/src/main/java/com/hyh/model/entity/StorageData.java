package com.hyh.model.entity;

import com.common.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 仓储数据
 * @author hyh
 * @date 2022/10/4 14:33
 */
@Getter
@NoArgsConstructor
public class StorageData extends BaseEntity {

    public StorageData(Warehouse warehouse, Cotton cotton, double weight) {
        this.warehouse = warehouse;
        this.cotton = cotton;
        this.weight = weight;
    }

    /**
     * 所在仓库
     */
    @Setter
    private Warehouse warehouse;

    /**
     * 棉花信息
     */
    @Setter
    private Cotton cotton;

    /**
     * 棉花重量
     */
    @Setter
    private double weight;

    /**
     * 减重
     * @param weight 需要减少的量
     */
    public void reduceWeight(double weight){
        this.weight-=weight;
    }

    /**
     * 增重
     * @param weight 需要增加的量
     */
    public void increaseWeight(double weight){
        this.weight+=weight;
    }
}
