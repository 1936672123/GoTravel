package com.go.hotel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.go.site.SHotel;
import com.go.view.HotelSkuV;
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
public interface ISHotelService extends IService<SHotel> {
    //添加酒店
    Result saveHotel(SHotel sHotel);

    //分页查询酒店
    PageResult<HotelSkuV> searchHotelByPage(Integer page, Integer limit, HotelSkuV hotelSkuV);

    //查询所有酒店
    List<HotelSkuV> findAllHotel();

}
