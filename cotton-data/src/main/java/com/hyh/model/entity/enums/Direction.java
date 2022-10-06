package com.hyh.model.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 物流方向（出入库）
 *
 * @author hyh
 * @date 2022/10/4 15:39
 */
@AllArgsConstructor
public enum Direction {


    /**
     * 出库
     */
    out_storage("出库", "out storage"),

    in_storage("入库", "in storage");

    @Getter
    private final String test;

    @Getter
    private final String value;

}
