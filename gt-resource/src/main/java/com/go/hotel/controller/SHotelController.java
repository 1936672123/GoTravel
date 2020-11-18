package com.go.hotel.controller;


import com.go.hotel.service.ISHotelService;
import com.go.site.SHotel;
import com.go.view.HotelSkuV;
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
@RequestMapping("/gt-resource/hotel")
public class SHotelController {

    @Autowired
    private ISHotelService isHotelService;

    @GetMapping("/findAllHotel")
    public List<HotelSkuV> findAllHotel(){
        List<HotelSkuV> allHotel = isHotelService.findAllHotel();
        return allHotel;
    }

    @PostMapping("/searchHotelByPage")
    public PageResult<HotelSkuV> searchHotelByPage(Integer page,Integer limit,@RequestBody HotelSkuV sHotel){
        PageResult<HotelSkuV> pageResult = isHotelService.searchHotelByPage(page, limit, sHotel);
        return pageResult;
    }


    @PostMapping("/saveHotel")
    public Result saveHotel(@RequestBody SHotel sHotel){
        Result result = isHotelService.saveHotel(sHotel);
        return result;
    }


}
