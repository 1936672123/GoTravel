package com.go.user;

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
public class UModule implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 权限编码id
     */
    private String moduleId;

    /**
     * 权限名称
     */
    private String moduleName;

    /**
     * 权限描述
     */
    private String moduleDesc;

    /**
     * 上级权限
     */
    private Integer parentModule;

    /**
     * 是否展开（0-不展开，1-展开）
     */
    private Integer expend;


}
