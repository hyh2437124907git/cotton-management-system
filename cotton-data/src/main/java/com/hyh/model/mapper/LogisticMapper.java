package com.hyh.model.mapper;

import com.hyh.model.mapper.base.MyBaseMapper;
import com.hyh.model.entity.Logistic;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hyh
 * @date 2022/10/4 16:31
 */
@Repository
public interface LogisticMapper extends MyBaseMapper<Logistic> {

    /**
     * 获取指定id的物流清单
     * @param id 物流清单Id
     * @return 物流清单数据
     */
    Logistic getById(String id);

    /**
     * 删除指定id的物流清单
     * @param id 物流清单Id
     */
    void delById(String id);

    /**
     * 获取所有物流清单信息
     * @return 所有物流清单数据
     */
    List<Logistic> getAll();
}
