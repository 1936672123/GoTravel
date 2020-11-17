package com.go.other;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 点评ID
     */
    @TableId(value = "comment_id", type = IdType.AUTO)
    private Integer commentId;

    /**
     * 点评详情
     */
    private String commentDesc;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 用户ID
     */
    private Integer userId;


}
