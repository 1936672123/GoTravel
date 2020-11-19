package com.go.order;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class OOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单ID
     */
    @TableId
    private String orderId;

    /**
     * 路线ID
     */
    private Integer routeId;

    /**
     * 套餐ID
     */
    private Integer skuId;

    /**
     * 订单金额
     */
    private Double money;

    /**
     * 创建订单时间
     */
    private Date createTime;

    /**
     * 修改订单时间
     */
    private Date updateTime;

    /**
     * 订单备注
     */
    private String orderNote;

    /**
     * 0，未支付；1，已支付； 2，已关闭
     */
    private Integer status;

    /**
     * 联系人姓名
     */
    private String linkmanName;

    /**
     * 联系人手机号
     */
    private String linkmanPhone;

    /**
     * 联系人邮箱
     */
    private String linkmanEmail;

    /**
     * 联系人微信
     */
    private String linkmanWx;

    /**
     * 旅客id
     */
    private Integer userId;

    /**
     * 旅客人数
     */
    private Integer travelerNum;

    /**
     * 订单详情
     */
    @TableField(exist=false)
    private List<OOrderDetail> orderDetails;


}
