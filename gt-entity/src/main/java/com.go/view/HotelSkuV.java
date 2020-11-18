package com.go.view;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author jobob
 * @since 2020-11-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("hotelSkuV")
public class HotelSkuV implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 酒店ID
     */
    private String hotelId;

    /**
     * 酒店名称
     */
    private String hotelName;

    /**
     * 酒店描述
     */
    private String hotelDesc;

    /**
     * 地点ID
     */
    private Integer siteId;

    /**
     * 酒店添加人员id
     */
    private Integer userId;

    /**
     * 酒店图片
     */
    private String hotelPic;

    /**
     * 主键ID
     */
    private Integer skuId;

    /**
     * 房型(1—单人、2—双人)
     */
    private Integer houseType;

    /**
     * 房间数量
     */
    private Integer houseNum;

    /**
     * 套餐库存数
     */
    private Integer remainCount;

    /**
     * 套餐价格
     */
    private Double price;


}
