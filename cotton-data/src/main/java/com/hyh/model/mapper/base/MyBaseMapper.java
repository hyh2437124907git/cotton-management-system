package com.hyh.model.mapper.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.common.entity.BaseEntity;
import com.hyh.annotation.IdGenerated;
import org.springframework.stereotype.Service;

/**
 * @author hyh
 * @date 2022/10/3 19:18
 */
@Service
public interface MyBaseMapper<T extends BaseEntity> extends BaseMapper<T> {

    /**
     * 保存对象
     * @param t 对象
     * @return true/false
     */
    @IdGenerated()
    boolean save(T t);
}
