package com.go.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
public class RRouteSite implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 路线ID
     */
    private Integer siteId;

    /**
     * 标签ID
     */
    private Integer routeId;


}
