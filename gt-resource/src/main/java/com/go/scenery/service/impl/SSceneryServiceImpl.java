package com.go.scenery.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.go.scenery.mapper.SSceneryMapper;
import com.go.scenery.service.ISSceneryService;
import com.go.site.SScenery;
import com.go.vo.PageResult;
import com.go.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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
public class SSceneryServiceImpl extends ServiceImpl<SSceneryMapper, SScenery> implements ISSceneryService {

    @Autowired
    private SSceneryMapper sSceneryMapper;

    //添加景点
    @Override
    public Result saveScenery(SScenery sScenery) {
        if((sScenery.getSceneryName()==null)||(sScenery.getSiteId()==null)||(sScenery.getUserId()==null)){
            return new Result(false,"添加失败");
        }
        sSceneryMapper.insert(sScenery);
        return new Result(true,"添加景点成功");
    }

    //分页+条件查询景点
    @Override
    public PageResult<SScenery> searchSceneryByPage(Integer page, Integer limit, SScenery sScenery) {
        Page<SScenery> sSceneryPage = new Page<>(page, limit);
        QueryWrapper<SScenery> queryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(sScenery.getSceneryName())){
            queryWrapper.eq("scenery_name",sScenery.getSceneryName());
        }
        if(!StringUtils.isEmpty(sScenery.getSceneryScore())){
            queryWrapper.eq("scenery_score",sScenery.getSceneryScore());
        }
        if(!StringUtils.isEmpty(sScenery.getSiteId())){
            queryWrapper.eq("site_id",sScenery.getSiteId());
        }
        if(!StringUtils.isEmpty(sScenery.getUserId())){
            queryWrapper.eq("user_id",sScenery.getUserId());
        }

        Page<SScenery> pageList = sSceneryMapper.selectPage(sSceneryPage, queryWrapper);

        return new PageResult<SScenery>(pageList.getRecords(), pageList.getTotal());
    }
}
