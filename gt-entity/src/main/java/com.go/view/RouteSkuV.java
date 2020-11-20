package com.go.view;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.go.route.RSku;
import com.go.site.SSite;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author jobob
 * @since 2020-11-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("routeSkuV")
public class RouteSkuV implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 线路ID
     */
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
     * 路线上传者id
     */
    private Integer travelerId;

    /**
     * 路线库存剩余数
     */
    private Integer routeRemain;

    /**
     * 上传路线时间
     */
    private Date createTime;

    /**
     * 修改路线时间
     */
    private Date updateTime;

    /**
     * 审核路线id
     */
    private Integer checkId;

    /**
     * 路线审核状态(0-待审核；1-审核通过；2-审核未通过)
     */
    private Integer checkStatus;

    /**
     * 路线审核时间
     */
    private Date checkTime;

    /**
     * 路线审核描述
     */
    private String checkDesc;

    /**
     * 路线分数（首页展示排名前8）
     */
    private Integer routeScore;

    /**
     * 审核人员id
     */
    private Integer userId;

    /**
     * 路线套餐
     */
    @TableField(exist=false)
    private List<RSku> rskus;

    /**
     * 路线地点
     */
    @TableField(exist=false)
    private List<SSite> ssites;

}
