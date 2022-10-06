package com.common.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author hyh
 * @date 2022/10/3 17:08
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseEntity {
    protected String id;
}
