package com.go.route;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RRoutecheck implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 审核路线id
     */
    @TableId(value = "check_id", type = IdType.AUTO)
    private Integer checkId;

    /**
     * 路线审核状态
     */
    private Integer checkStatus;// 0-待审核；1-审核通过；2-审核未通过

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
