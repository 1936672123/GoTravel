package com.go.other;

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
public class Picture implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 地点图片id
     */
    @TableId(value = "pic_id", type = IdType.AUTO)
    private Integer picId;

    /**
     * 地点图片路径
     */
    private String picUrl;

    /**
     * 地点ID
     */
    private Integer siteId;

    /**
     * 美食ID
     */
    private Integer foodId;

    /**
     * 景点ID
     */
    private Integer sceneryId;

    /**
     * 酒店ID
     */
    private Integer hotelId;

    /**
     * 点评ID
     */
    private Integer commentId;


}
