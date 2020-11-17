package com.go.route;

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
public class RRouteTag implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     *  路线ID
     */
    private Integer routeId;

    /**
     * 标签ID
     */
    private Integer tagId;


}
