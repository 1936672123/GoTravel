package com.go.route.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.go.route.RRoute;
import com.go.route.RSku;
import com.go.route.RTag;
import com.go.site.SSite;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-11-17
 */
public interface RRouteMapper extends BaseMapper<RRoute> {

    //通过路线id查询所有的套餐
    List<RSku> getRSkuByRouteId(String routeId);

    //通过路线id查询所有的地点
    List<SSite> getSitesByRouteId(String routeId);

    //通过路线id查询所有的标签
    List<RTag> getTagsByRouteId(String routeId);

}
