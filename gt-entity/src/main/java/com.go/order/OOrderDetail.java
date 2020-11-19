package com.go.order;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2020-11-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OOrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单详细id
     */
    @TableId("orderDetail_id")
    private Integer orderdetailId;

    /**
     * 旅客姓名
     */
    private String travelerName;

    /**
     * 旅客性别
     */
    private String travelerSex;

    /**
     * 证件类型
     */
    @TableField("ID_type")
    private String idType;

    /**
     * 证件号
     */
    @TableField("ID_no")
    private String idNo;

    /**
     * 旅客手机号
     */
    private String travelerPhone;

    /**
     * 常用旅客（0-不是，1-是）
     */
    private Integer defaultTraveler;

    /**
     * 订单id
     */
    private String orderId;



}
