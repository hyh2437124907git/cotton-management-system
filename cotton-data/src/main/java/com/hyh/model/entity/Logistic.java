package com.hyh.model.entity;

import com.common.entity.BaseEntity;
import com.hyh.model.entity.enums.Direction;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * 物流清单
 * @author hyh
 * @date 2022/10/4 15:37
 */
@Getter
public class Logistic extends BaseEntity {

    public Logistic(Direction direction, StorageData storageData, double weight, LocalDateTime dateTime) {
        this.direction = direction;
        this.storageData = storageData;
        this.weight = weight;
        this.dateTime = dateTime;
    }

    /**
     * 物流方向(出入库)
     */
    private Direction direction;

    /**
     * 具体数据
     */
    private StorageData storageData;


    /**
     * 需要更新的重量
     */
    private double weight;


    private LocalDateTime dateTime;

}
