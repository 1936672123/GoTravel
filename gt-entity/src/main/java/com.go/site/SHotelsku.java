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
public class SHotelsku implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

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
     * 价格
     */
    private Double price;


    /**
     * 酒店id
     */
    private String hotelId;




}
