package com.hyh.model.mapper;

import com.hyh.model.entity.Cotton;
import com.hyh.model.entity.enums.Color;
import com.hyh.model.entity.enums.Rank;
import com.hyh.model.mapper.base.MyBaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hyh
 * @date 2022/10/3 18:17
 */
@Repository
public interface CottonMapper extends MyBaseMapper<Cotton> {

    /**
     * 获取指定id的棉花
     * @param id 棉花Id
     * @return 棉花数据
     */
    Cotton getById(String id);

    /**
     * 删除指定id的棉花
     * @param id 棉花Id
     * @return true/false
     */
    boolean delById(String id);

    /**
     * 获取所有棉花信息
     * @return 所有棉花数据
     */
    List<Cotton> getAll();

    /**
     * 获取指定颜色的棉花
     * @param color 颜色
     * @return 限定条件下的棉花
     */
    List<Cotton> getByColor(Color color);

    /**
     * 获取指定等级的棉花
     * @param rank 等级
     * @return 限定条件下的棉花
     */
    List<Cotton> getByRank(Rank rank);

    /**
     * 获取指定来源的棉花
     * @param source 来源
     * @return 限定条件下的棉花
     */
    List<Cotton> getBySource(String source);

    /**
     * 根据任意条件获取满足条件的棉花
     * @param cotton 存放条件的对象
     * @return 满足条件的棉花
     */
    List<Cotton> getByCotton(Cotton cotton);

}
