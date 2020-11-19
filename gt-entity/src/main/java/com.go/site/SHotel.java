package com.go.site;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
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
public class SHotel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 酒店ID
     */
    @TableId
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
     * 添加人员id
     */
    private Integer userId;

    /**
     * 图片
     */
    private String hotelPic;

    /**
     * 酒店套餐
     */
    @TableField(exist=false)
    private List<SHotelsku> hotelSkus;


}
