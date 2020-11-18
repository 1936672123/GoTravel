package com.go.scenery.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.go.site.SScenery;
import com.go.vo.PageResult;
import com.go.vo.Result;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2020-11-17
 */
public interface ISSceneryService extends IService<SScenery> {

    //添加景点
    Result saveScenery(SScenery sScenery);


    //查询所有景点
    List<SScenery> findAllScenery();

    //分页+条件查询景点
    PageResult<SScenery> searchSceneryByPage(Integer page,Integer limit,SScenery sScenery);

    //通过siteId查询所有的景点
    PageResult<SScenery> getSceneryByPage(Integer current,Integer limit,Integer siteId);

}
