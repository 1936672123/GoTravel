package com.go.route.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.go.food.mapper.SFoodMapper;
import com.go.hotel.mapper.SHotelMapper;
import com.go.route.*;
import com.go.route.mapper.*;
import com.go.route.service.IRRouteService;
import com.go.site.SFood;
import com.go.site.SHotel;
import com.go.site.SSite;
import com.go.view.RouteSkuV;
import com.go.vo.PageResult;
import com.go.vo.Result;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    private RSkuMapper rSkuMapper;

    @Autowired
    private RRoutecheckMapper rRoutecheckMapper;

    @Autowired
    private RouteSkuVMapper routeSkuVMapper;



    @Autowired
    private RRouteTagMapper rRouteTagMapper;
    @Autowired
    private RRouteSiteMapper rRouteSiteMapper;

    @Autowired
    private SHotelMapper sHotelMapper;
    @Autowired
    private SFoodMapper sFoodMapper;

    @Autowired
    private RocketMQTemplate rocketMQTemplate;


    //----------------------------后台管理-----------------------------------

    //添加路线
    @Override
    public Result saveRoute(RRoute rRoute) {

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

        //添加路线主表
        String routeId= UUID.randomUUID().toString();//生成routeId
        rRoute.setRouteId(routeId);
        Date date = new Date();
        rRoute.setCreateTime(date);
        rRoute.setUpdateTime(date);
        rRoute.setSaleCount(0);
        rRoute.setViewCount(0);
        rRouteMapper.insert(rRoute);

        //添加路线套餐信息
        List<RSku> rskus = rRoute.getRskus();
        for (RSku rSku : rskus) {
            rSku.setRouteId(routeId);
            rSkuMapper.insert(rSku);
        }


        //添加路线地点信息
        List<SSite> ssites = rRoute.getRsites();
        for (SSite ssite : ssites) {
            RRouteSite rRouteSite = new RRouteSite();
            rRouteSite.setRouteId(routeId);
            rRouteSite.setSiteId(ssite.getSiteId());
            rRouteSiteMapper.insert(rRouteSite);
        }


        //添加路线审核相关信息
        RRoutecheck rRoutecheck = new RRoutecheck();
        rRoutecheck.setRouteId(routeId);
        rRoutecheck.setCheckStatus(0);
        rRoutecheck.setRouteScore(0);
        rRoutecheckMapper.insert(rRoutecheck);

        //添加路线标签信息
        for (SSite ssite : ssites) {
            Integer siteId = ssite.getSiteId();
            //获取该地点所有酒店
            QueryWrapper<SHotel> qw = new QueryWrapper<>();
            qw.eq("site_id",siteId);
            List<SHotel> sHotels = sHotelMapper.selectList(qw);
            if(sHotels.size()!=0){
                //添加度假酒店标签
                RRouteTag rRouteTag = new RRouteTag();
                rRouteTag.setRouteId(routeId);
                rRouteTag.setTagId(1);//添加"度假酒店"标签
                rRouteTagMapper.insert(rRouteTag);
                break;
            }
        }
        for (SSite ssite : ssites) {
            Integer siteId = ssite.getSiteId();
            //获取该地点所有的美食
            QueryWrapper<SFood> qw1 = new QueryWrapper<>();
            qw1.eq("site_id",siteId);
            List<SFood> sFoods = sFoodMapper.selectList(qw1);
            if(sFoods.size()!=0){
                //添加度假酒店标签
                RRouteTag rRouteTag = new RRouteTag();
                rRouteTag.setRouteId(routeId);
                rRouteTag.setTagId(2);//添加"餐饮美食"标签
                rRouteTagMapper.insert(rRouteTag);
                break;
            }
        }

        return new Result(true,"添加路线成功");
    }



    //商家修改路线
    @Override
    public Result updateRoute(RRoute rRoute) {

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

        //修改路线主表
        String routeId = rRoute.getRouteId();//获取路线id
        rRoute.setUpdateTime(new Date());
        rRouteMapper.updateById(rRoute);


        //修改路线套餐信息
        UpdateWrapper<RSku> wrapper = new UpdateWrapper<>();
        wrapper.eq("route_id",routeId);
        //先删除routeId所有的路线套餐
        rSkuMapper.delete(wrapper);
        //再添加新的路线套餐
        List<RSku> rskus = rRoute.getRskus();
        for (RSku rSku : rskus) {
            rSku.setRouteId(routeId);
            rSkuMapper.insert(rSku);
        }


        //修改路线审核状态
        UpdateWrapper<RRoutecheck> qw = new UpdateWrapper<>();
        qw.set("check_status",0).eq("route_id",routeId);  //将路线审核状态修改为0（待审核）
        rRoutecheckMapper.update(null,qw);


        //修改路线地点信息
        UpdateWrapper<RRouteSite> wrapper1 = new UpdateWrapper<>();//先删除路线相关地点
        wrapper1.eq("route_id",routeId);
        rRouteSiteMapper.delete(wrapper1);
        List<SSite> ssites = rRoute.getRsites(); //获取前端传来的所有的地点id  //重新添加新的地点信息
        for (SSite ssite : ssites) {
            RRouteSite rRouteSite = new RRouteSite();
            rRouteSite.setRouteId(routeId);
            rRouteSite.setSiteId(ssite.getSiteId());
            rRouteSiteMapper.insert(rRouteSite);
        }


        //修改路线标签信息
        UpdateWrapper<RRouteTag> wrapper2 = new UpdateWrapper<>();//先删除路线相关的标签
        wrapper2.eq("route_id",routeId);
        rRouteTagMapper.delete(wrapper2);
        for (SSite ssite : ssites) { //重新添加新的标签信息
            Integer siteId = ssite.getSiteId();
            //获取该地点所有酒店
            QueryWrapper<SHotel> qw1 = new QueryWrapper<>();
            qw.eq("site_id",siteId);
            List<SHotel> sHotels = sHotelMapper.selectList(qw1);
            if(sHotels.size()!=0){
                //添加度假酒店标签
                RRouteTag rRouteTag = new RRouteTag();
                rRouteTag.setRouteId(routeId);
                rRouteTag.setTagId(1);//添加"度假酒店"标签
                rRouteTagMapper.insert(rRouteTag);
                break;
            }
        }
        for (SSite ssite : ssites) {
            Integer siteId = ssite.getSiteId();
            //获取该地点所有的美食
            QueryWrapper<SFood> qw1 = new QueryWrapper<>();
            qw1.eq("site_id",siteId);
            //判断该地点是否有美食
            List<SFood> sFoods = sFoodMapper.selectList(qw1);
            if(sFoods.size()!=0){
                //添加度假酒店标签
                RRouteTag rRouteTag = new RRouteTag();
                rRouteTag.setRouteId(routeId);
                rRouteTag.setTagId(2);//添加"餐饮美食"标签
                rRouteTagMapper.insert(rRouteTag);
                break;
            }
        }

        //todo:同步索引库，删除此条记录


        return new Result(true,"修改路线成功");
    }


    //删除路线套餐
    @Override
    public Result deleteRouteSku(Integer skuId) {
        int i = rSkuMapper.deleteById(skuId);
        return new Result(true,"删除路线套餐成功");
    }

    //商家分页+条件查询 (路线、路线审核信息+路线套餐)
    @Override
    public PageResult<RouteSkuV> getRoutes(Integer current, Integer limit, RouteSkuV routeSkuV) {
        //创建分页构造器
        Page<RouteSkuV> page = new Page<>(current,limit);
        //创建条件构造器
        QueryWrapper<RouteSkuV> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("traveler_id",routeSkuV.getTravelerId());
        if(!StringUtils.isEmpty(routeSkuV.getRouteTitle())){
            queryWrapper.like("route_title",routeSkuV.getRouteTitle());
        }
        if(!StringUtils.isEmpty(routeSkuV.getCheckStatus())){
            queryWrapper.eq("check_status",routeSkuV.getCheckStatus());
        }
        Page<RouteSkuV> page1 = routeSkuVMapper.selectPage(page, queryWrapper);
        //对路线进行处理，将其套餐信息、路线信息、地点添加进去
        List<RouteSkuV> routeSkuVS = page1.getRecords();
        for (RouteSkuV route : routeSkuVS) {
            String routeId=route.getRouteId();
            List<RSku> skuList = rRouteMapper.getRSkuByRouteId(routeId);
            List<RTag> tagList = rRouteMapper.getTagsByRouteId(routeId);
            List<SSite> siteList = rRouteMapper.getSitesByRouteId(routeId);
            route.setRskus(skuList);
            route.setRTags(tagList);
            route.setSsites(siteList);
        }
        return new PageResult<>(routeSkuVS,page1.getTotal());
    }


    //------------------------------后台审核-----------------------------------

    //路线审核人员查询
    @Override
    public PageResult<RouteSkuV> getRoutesWithCheck(Integer current,Integer limit,RouteSkuV routeSkuV) {
        Page<RouteSkuV> page = new Page<>(current, limit);
        QueryWrapper<RouteSkuV> qw = new QueryWrapper<>();
        if(!StringUtils.isEmpty(routeSkuV.getRouteId())){
            qw.eq("route_id",routeSkuV.getRouteId());
        }
        if(!StringUtils.isEmpty(routeSkuV.getRouteTitle())){
            qw.like("route_title",routeSkuV.getRouteTitle());
        }
        if(!StringUtils.isEmpty(routeSkuV.getTravelerId())){
            qw.eq("traveler_id",routeSkuV.getTravelerId());
        }
        if(!StringUtils.isEmpty(routeSkuV.getCheckStatus())){
            qw.eq("check_status",routeSkuV.getCheckStatus());
        }
        Page<RouteSkuV> page1 = routeSkuVMapper.selectPage(page, qw);
        //对路线进行处理，将其套餐信息、路线信息、地点添加进去
        List<RouteSkuV> routes = page1.getRecords();
        for (RouteSkuV route : routes) {
            String routeId=route.getRouteId();
            List<RSku> skuList = rRouteMapper.getRSkuByRouteId(routeId);
            List<RTag> tagList = rRouteMapper.getTagsByRouteId(routeId);
            List<SSite> siteList = rRouteMapper.getSitesByRouteId(routeId);
            route.setRskus(skuList);
            route.setRTags(tagList);
            route.setSsites(siteList);
        }
        return new PageResult<RouteSkuV>(routes,page1.getTotal());
    }


    //路线审核人员审核
    @Override
    public Result checkRoute(RRoutecheck rRoutecheck) {
        if(StringUtils.isEmpty(rRoutecheck.getCheckDesc())){
            rRoutecheck.setCheckDesc(null);
        }
        rRoutecheck.setCheckTime(new Date());
        RRoutecheck check = rRoutecheckMapper.selectById(rRoutecheck.getCheckId());
        int i = rRoutecheckMapper.updateById(rRoutecheck);
        System.out.println("i="+i);
        //todo: 使用rocketMQ发送消息同步索引库
        if((0!=i)&&(rRoutecheck.getCheckStatus()==1)&&(check.getCheckStatus()!=1)){
            System.out.println("同步索引库");
            //获取同步索引库的数据
            RouteSkuV routeSkuV = getRouteSkuV(rRoutecheck.getRouteId());
            //同步索引库
            rocketMQTemplate.syncSend("gt-resource-route:addRoute",routeSkuV);
        }
        return new Result(true,"审核-修改路线状态成功");
    }

    //审核修改路线分数
    @Override
    public Result updateRouteScore(RRoutecheck rRoutecheck) {
        int i = rRoutecheckMapper.updateById(rRoutecheck);
        return new Result(true,"审核-修改路线分数成功");
    }


    //通过routeId获取路线相关信息（主信息、套餐、标签、地点）
    @Override
    public RouteSkuV getRouteSkuV(String routeId){
        RouteSkuV routeSkuV = routeSkuVMapper.selectById(routeId);
        routeSkuV.setRskus(rRouteMapper.getRSkuByRouteId(routeId));
        routeSkuV.setRTags(rRouteMapper.getTagsByRouteId(routeId));
        routeSkuV.setSsites(rRouteMapper.getSitesByRouteId(routeId));
        return  routeSkuV;
    }




}
