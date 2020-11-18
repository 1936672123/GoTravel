package com.go.site;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2020-11-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SHotel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 酒店ID
     */
    @TableId(value = "hotel_id", type = IdType.AUTO)
    private Integer hotelId;

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
     * 人员id
     */
    private Integer userId;


}
