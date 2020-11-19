package com.go.route.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.go.route.RRoute;
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

    //--------后台---------

    //添加路线
    Result saveRoute(RRoute rRoute);


    //---------前台---------



}
