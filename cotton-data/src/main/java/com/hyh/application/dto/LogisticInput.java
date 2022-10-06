package com.hyh.application.dto;

import com.hyh.model.entity.Logistic;
import com.hyh.model.entity.StorageData;
import com.hyh.model.entity.enums.Direction;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 物流清单
 * @author hyh
 * @date 2022/10/4 15:37
 */
@Data
public class LogisticInput {

    public LogisticInput(Direction direction, String warehouseId, String cottonId, double weight) {
        this.direction = direction;
        this.warehouseId = warehouseId;
        this.cottonId = cottonId;
        this.weight = weight;
    }

    /**
     * 物流方向(出入库)
     */
    private Direction direction;

    /**
     * 所选择的仓库
     */
    private String warehouseId;

    /**
     * 棉花信息
     */
    private String cottonId;

    /**
     * 需要更新的重量
     */
    private double weight;


    public Logistic mapTo(StorageData storageData){
        return new Logistic(direction, storageData, weight, LocalDateTime.now());
    }

}
