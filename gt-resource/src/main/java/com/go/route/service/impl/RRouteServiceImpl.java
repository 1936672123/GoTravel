package com.go.route.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.go.route.RRoute;
import com.go.route.mapper.RRouteMapper;
import com.go.route.mapper.RRouteTagMapper;
import com.go.route.mapper.RRoutecheckMapper;
import com.go.route.mapper.RSkuMapper;
import com.go.route.service.IRRouteService;
import com.go.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-11-17
 */
@Service
@Transactional
public class RRouteServiceImpl extends ServiceImpl<RRouteMapper, RRoute> implements IRRouteService {

    @Autowired
    private RRouteMapper rRouteMapper;
    @Autowired
    private RRouteTagMapper rRouteTagMapper;
    @Autowired
    private RSkuMapper rSkuMapper;
    @Autowired
    private RRoutecheckMapper rRoutecheckMapper;

    //添加路线
    @Override
    public Result saveRoute(RRoute rRoute) {

        //添加路线主表
        if(rRoute.getRoutePic1()==""){
            rRoute.setRoutePic1(null);
        }
        if(rRoute.getRoutePic2()==""){
            rRoute.setRoutePic2(null);
        }
        if(rRoute.getRoutePic3()==""){
            rRoute.setRoutePic3(null);
        }
        if(rRoute.getNote()==""){
            rRoute.setNote(null);
        }
        Date date = new Date();
        rRoute.setCreateTime(date);
        rRoute.setUpdateTime(date);
        rRouteMapper.insert(rRoute);

        //添加路线标签


        return null;
    }




}
