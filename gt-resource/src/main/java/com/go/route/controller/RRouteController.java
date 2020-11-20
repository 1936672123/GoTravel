package com.go.route.controller;


import com.go.dto.RouteDTO;
import com.go.route.RRoute;
import com.go.route.RRoutecheck;
import com.go.route.service.IRRouteService;
import com.go.view.RouteSkuV;
import com.go.vo.PageResult;
import com.go.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-11-17
 */
@RestController
@RequestMapping("/gt-resource/route")
public class RRouteController {

    @Autowired
    private IRRouteService irRouteService;

    //-----------------后台管理----------------------------------

    //商家添加路线
    @PostMapping("/saveRoute")
    public Result saveRoute(@RequestBody RRoute rRoute){

        //todo:获取用户id
        Integer userId=1;

        rRoute.setTravelerId(userId);
        Result result = irRouteService.saveRoute(rRoute);
        return result;
    }

    //商家修改路线
    @PostMapping("/updateRoute")  // 参数  route{,,, rskus:{} }
    public Result updateRoute(@RequestBody RRoute rRoute){

        Result result = irRouteService.updateRoute(rRoute);
        return result;
    }

    //商家删除路线套餐
    @GetMapping("/deleteRouteSku")
    public Result deleteRoute(Integer skuId){
        Result result = irRouteService.deleteRouteSku(skuId);
        return result;
    }

    //商家查询路线
    @PostMapping("/getRoute")   //参数（routeTitle,checkStatus）
    public PageResult<RouteSkuV> getRoute(Integer page, Integer limit, @RequestBody RouteSkuV routeSkuV){

        //todo:获取用户id
        Integer userId=1;
        routeSkuV.setTravelerId(userId);
        PageResult<RouteSkuV> pageResult = irRouteService.getRoutes(page, limit,routeSkuV);
        return pageResult;
    }

    //通过routeId查询
    @GetMapping("/getRouteByRouteId")
    public RRoute getRouteByRouteId(String routeId){
        RRoute rRoute = irRouteService.getById(routeId);
        return rRoute;
    }

    //-----------------------------后台审核-------------------------------

    //路线审核人员查询路线
    @PostMapping("/getRoutesWithCheck")  // 参数 { routeId ,routeTitle, travelerId, checkStatus }
    public PageResult<RouteSkuV> getRoutesWithCheck(Integer page,Integer limit,@RequestBody RouteSkuV routeSkuV){
        PageResult<RouteSkuV> pageResult = irRouteService.getRoutesWithCheck(page, limit, routeSkuV);
        return pageResult;
    }

    //路线审核人员审核路线（修改路线状态和路线的排名分数）
    @PostMapping("/checkRoute")  // 参数 {string: routeId, int:checkId, int:checkStatus, string:checkDesc}
    public Result checkRoute(@RequestBody RouteSkuV routeSkuV) {
        //todo: 获取审核人员id
        Integer userId=1;

        routeSkuV.setUserId(userId);
        Result result = irRouteService.checkRoute(routeSkuV);
        return result;
    }

    //审核人员修改路线分数
    @PostMapping("/updateRouteScore")   //参数 {int: checkId, int: routeScore}
    public Result updateRouteScore(@RequestBody RRoutecheck rRoutecheck) {
        //todo: 获取审核人员id
        Integer userId=1;

        rRoutecheck.setUserId(userId);
        Result result = irRouteService.updateRouteScore(rRoutecheck);
        return result;
    }

}
