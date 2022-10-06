package com.hyh.model.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 包装方式
 * @author hyh
 * @date 2022/10/4 15:33
 */
@AllArgsConstructor
public enum Packing {


    /**
     * 散装
     */
    BULK("散装","bulk");

    @Getter
    private final String test;

    @Getter
    private final String value;

}
