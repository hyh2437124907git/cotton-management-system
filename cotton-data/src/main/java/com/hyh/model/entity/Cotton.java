package com.hyh.model.entity;

import com.common.entity.BaseEntity;
import com.hyh.model.entity.enums.Color;
import com.hyh.model.entity.enums.Rank;
import lombok.Getter;

/**
 * 棉花
 * @author hyh
 * @date 2022/10/3 16:40
 */
@Getter
public class Cotton extends BaseEntity {

    public Cotton(String id, String variety, Color color, Rank rank,
                  String source) {
        super(id);
        this.variety = variety;
        this.color = color;
        this.rank = rank;
        this.source = source;
    }
    public Cotton(String variety, Color color, Rank rank,
                  String source) {
        this.variety = variety;
        this.color = color;
        this.rank = rank;
        this.source = source;
    }


    /**
     * 品种
     */
    private final String variety;

    /**
     * 颜色
     */
    private final Color color;

    /**
     * 等级
     */
    private final Rank rank;

    /**
     * 来源
     */
    private final String source;



    @Override
    public String toString() {
        return "Cotton{" +
                "variety='" + variety + '\'' +
                ", color=" + color +
                ", rank=" + rank +
                ", source='" + source + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
