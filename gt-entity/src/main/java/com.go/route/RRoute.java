package com.go.route;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.go.site.SSite;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
public class RRoute implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 线路ID
     */
    @TableId
    private String routeId;

    /**
     * 线路标题
     */
    private String routeTitle;

    /**
     * 线路描述
     */
    private String routeDesc;

    /**
     * 图片1
     */
    private String routePic1;

    /**
     * 图片2
     */
    private String routePic2;

    /**
     * 图片3
     */
    private String routePic3;

    /**
     * 起始价格
     */
    private Double startPrice;

    /**
     * 销售数量
     */
    private Integer saleCount;


    /**
     * 游览量
     */
    private Integer viewCount;

    /**
     * 温馨提示
     */
    private String note;

    /**
     * 发布路线的旅游社ID
     */
    private Integer travelId;

    /**
     * 产品类型(自由行、跟团游)
     */
    private String routeType;

    /**
     * 路线创建时间
     */
    private Date createTime;

    /**
     * 路线修改时间
     */
    private Date updateTime;

    /**
     * 路线库存数
     */
    private Integer routeRemain;


    /**
     * 路线审核信息
     */
    @TableField(exist=false)
    private RRoutecheck routecheck;

    /**
     * 路线标签信息
     */
    @TableField(exist=false)
    private List<RTag> rtags;

    /**
     * 路线套餐信息
     */
    @TableField(exist=false)
    private List<RSku> rskus;

    /**
     * 路线地点信息
     */
    @TableField(exist=false)
    private List<SSite> ssites;


}
