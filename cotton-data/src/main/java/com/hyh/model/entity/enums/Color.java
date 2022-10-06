package com.hyh.model.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 棉花颜色
 *
 * @author hyh
 * @date 2022/10/3 16:50
 */
@AllArgsConstructor
public enum Color {

    /**
     * 白棉花
     */
    WHITE("白色", "white"),

    /**
     * 淡黄色
     */
    LIGHT_YELLOW("淡黄色", "light yellow");

    @Getter
    private final String text;

    @Getter
    private final String value;

}
