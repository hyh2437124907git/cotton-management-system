package com.hyh.model.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 棉花等级
 *
 * @author hyh
 * @date 2022/10/3 16:52
 */
@AllArgsConstructor
public enum Rank {

    /**
     * 一级
     */
    Level_1("一级", "level 1"),

    /**
     * 二级
     */
    Level_2("二级", "level 2"),

    /**
     * 三级
     */
    Level_3("三级", "level 3");

    @Getter
    private final String text;

    @Getter
    private final String value;

}
