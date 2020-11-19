package com.go.route;

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
 * @since 2020-11-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RRoutecheck implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 审核路线id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 路线审核状态
     */
    private String checkStatus;

    /**
     * 路线审核时间
     */
    private Date checkTime;

    /**
     * 路线审核描述
     */
    private String checkDesc;

    /**
     * 路线排序分数
     */
    private Integer routeScore;

    /**
     * 审核人员id
     */
    private Integer userId;

    /**
     * 线路ID
     */
    private String routeId;


}
