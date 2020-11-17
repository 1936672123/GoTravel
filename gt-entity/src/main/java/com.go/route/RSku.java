package com.go.route;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

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
public class RSku implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 路线套餐ID
     */
    @TableId(value = "sku_id", type = IdType.AUTO)
    private Integer skuId;

    /**
     * 出行时间
     */
    private Date goTime;

    /**
     * 路线套餐名称
     */
    private String skuName;

    /**
     * 路线套餐价格
     */
    private Double skuPrice;

    /**
     * 出行人数
     */
    private Integer memberNum;

    /**
     * 线路主表ID
     */
    private Integer routeId;


}
