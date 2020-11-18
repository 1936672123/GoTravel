package com.go.scenery.controller;


import com.go.scenery.service.ISSceneryService;
import com.go.site.SScenery;
import com.go.vo.PageResult;
import com.go.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-11-17
 */
@RestController
@RequestMapping("/gt-resource/scenery")
public class SSceneryController {

    @Autowired
    private ISSceneryService isSceneryService;

    @PostMapping("/saveScenery")
    public Result saveScenery(@RequestBody SScenery sScenery){

        //todo:从springSecurity中获取用户id
        Integer user_id=1;

        sScenery.setUserId(user_id);
        Result result = isSceneryService.saveScenery(sScenery);
        return result;
    }

    @PostMapping("/searchByPage")
    public PageResult searchSceneryByPage(Integer page, Integer limit, @RequestBody SScenery sScenery){
        PageResult<SScenery> pageResult = isSceneryService.searchSceneryByPage(page, limit, sScenery);
        return pageResult;
    }


}
