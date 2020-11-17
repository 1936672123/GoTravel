package com.go.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
    private Integer routeId;

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
    private String travelId;

    /**
     * 产品类型(自由行、跟团游)
     */
    private String typeId;

    /**
     * 创建时间
     */
    private Date createTime;


}
