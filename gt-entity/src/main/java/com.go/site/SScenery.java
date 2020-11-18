package com.go.site;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2020-11-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SScenery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 景点ID
     */
    @TableId(value = "scenery_id", type = IdType.AUTO)
    private Integer sceneryId;

    /**
     * 景点名称
     */
    private String sceneryName;

    /**
     * 景点描述
     */
    private String sceneryDesc;

    /**
     * 景点评分
     */
    private Integer sceneryScore;

    /**
     * 景点门票价格
     */
    private Double sceneryPrice;

    /**
     * 地点ID
     */
    private Integer siteId;

    /**
     * 人员id
     */
    private Integer userId;


}
