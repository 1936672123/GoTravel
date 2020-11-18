package com.go.site.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.go.site.SSite;
import com.go.site.mapper.SSiteMapper;
import com.go.site.service.ISSiteService;
import com.go.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-11-17
 */
@Service
public class SSiteServiceImpl extends ServiceImpl<SSiteMapper, SSite> implements ISSiteService {

    @Autowired
    private SSiteMapper sSiteMapper;

    @Override
    public SSite descSearch(Integer siteId) {
        return sSiteMapper.selectById(siteId);
    }

    @Override
    public List<String> hotSearch() {
        QueryWrapper<SSite> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("site_order");
        List<SSite> sSites = sSiteMapper.selectList(queryWrapper);
        List<String> sitesAll = new ArrayList<>();
        for (SSite sSite : sSites) {
            sitesAll.add(sSite.getSiteName());
        }
        List sites = sitesAll.subList(0,10);

        return sites;

    }

    @Override
    public Result createSite(SSite sSite) {

        int num = sSiteMapper.insert(sSite);
        if (num!=0){
            return new Result(true, "添加成功");
        }else{
            return new Result(false, "添加失败");
        }

    }

    @Override
    public Result deleteSite(Integer siteId) {
        int num = sSiteMapper.deleteById(siteId);
        if (num!=0){
            return new Result(true, "删除成功");
        }else{
            return new Result(false, "删除失败");
        }
    }


}
