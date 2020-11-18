package com.go.site.controller;
import com.go.site.SSite;
import com.go.site.service.ISSiteService;
import com.go.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/gt/site")
public class SSiteController {

    @Autowired
    private ISSiteService isSiteService;

    /**
     * 查询地点详情
     * @return
     */
    @RequestMapping("/descSearch")
    public SSite descSearch(Integer siteId){
        return isSiteService.descSearch(siteId);
    }

    /**
     * 查询热门地点
     */
    @RequestMapping("/hotSearch")
    public List<String> hotSearch(){
        return isSiteService.hotSearch();
    }



    /**
     * 添加地点
     */
    @RequestMapping("/createSite")
    public Result createSite(@RequestBody SSite sSite){
        return isSiteService.createSite(sSite);
    }


    /**
     * 删除地点
     */
    @RequestMapping("/deleteSite")
    public Result deleteSite(Integer siteId){
        return isSiteService.deleteSite(siteId);
    }

}
