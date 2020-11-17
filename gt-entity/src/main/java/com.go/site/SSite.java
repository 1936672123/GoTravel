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
public class SSite implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 地点ID
     */
    @TableId(value = "site_id", type = IdType.AUTO)
    private Integer siteId;

    /**
     * 地点名称
     */
    private String siteName;

    /**
     * 地点描述
     */
    private String siteDesc;


}
