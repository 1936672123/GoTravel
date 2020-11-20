package com.go.route.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.go.dto.RouteDTO;
import com.go.route.RRoute;
import com.go.route.RRoutecheck;
import com.go.view.RouteSkuV;
import com.go.vo.PageResult;
import com.go.vo.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2020-11-17
 */
public interface IRRouteService extends IService<RRoute> {

    //--------------------后台管理--------------------

    //添加路线
    Result saveRoute(RRoute rRoute);
    //修改路线
    Result updateRoute(RRoute rRoute);
    //删除路线套餐
    Result deleteRouteSku(Integer skuId);
    //分页+条件查询路线
    PageResult<RouteSkuV> getRoutes(Integer current, Integer limit,RouteSkuV routeSkuV);


    //------------------------------后台审核-------------------------

    //路线审核人员查询路线
    PageResult<RouteSkuV> getRoutesWithCheck(Integer current,Integer limit,RouteSkuV routeSkuV);
    //审核路线
    Result checkRoute(RouteSkuV routeSkuV);

    //路线审核人员修改路线分数
    Result updateRouteScore(RRoutecheck rRoutecheck);



    //------------------------------前台---------------------------------

}
