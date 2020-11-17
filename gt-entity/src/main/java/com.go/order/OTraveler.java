package com.go.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
public class OTraveler implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单旅客ID
     */
    @TableId(value = "traveler_id", type = IdType.AUTO)
    private Integer travelerId;

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 旅客姓名
     */
    private String travelerName;

    /**
     * 旅客性别
     */
    private String travelerSex;

    /**
     * 出生日期
     */
    private Date travelerBirth;

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
    private String traverlPhone;

    /**
     * 是否设为常用旅客(0,非默认;1,默认)
     */
    private Integer defaultTraveler;


}
