package com.go.route;

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
public class RSku implements Serializable {

    public static void main(String[] args) {
        System.out.println("pkkkkkkk");
    }

    private static final long serialVersionUID = 1L;

    /**
     *  套餐ID
     */
    private Integer skuId;

    /**
     * 出行时间
     */
    private Date startTime;

    /**
     * 套餐名称
     */
    private String skuName;

    /**
     * 套餐价格
     */
    private Double skuPrice;

    /**
     * 出行人数
     */
    private Integer menberNum;

    /**
     * 线路主表ID
     */
    private Integer routeId;


}
