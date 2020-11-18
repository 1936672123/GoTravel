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
public class SFood implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 美食ID
     */
    @TableId(value = "food_id", type = IdType.AUTO)
    private Integer foodId;

    /**
     * 美食名称
     */
    private String foodName;

    /**
     * 美食描述
     */
    private String foodDesc;

    /**
     * 美食评分
     */
    private String foodScore;

    /**
     * 地点ID
     */
    private Integer siteId;

    /**
     * 人员id
     */
    private Integer userId;

    /**
     * 图片
     */
    private String foodPic;


}
