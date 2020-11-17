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
public class Tag implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标签ID
     */
    @TableId(value = "tag_id", type = IdType.AUTO)
    private Integer tagId;

    /**
     * 标签名称
     */
    private String tagName;


}
