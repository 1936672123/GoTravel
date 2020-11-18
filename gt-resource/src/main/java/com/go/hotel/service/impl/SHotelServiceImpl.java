package com.go.hotel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.go.hotel.mapper.HotelSkuVMapper;
import com.go.hotel.mapper.SHotelMapper;
import com.go.hotel.mapper.SHotelskuMapper;
import com.go.hotel.service.ISHotelService;
import com.go.site.SHotel;
import com.go.site.SHotelsku;
import com.go.view.HotelSkuV;
import com.go.vo.PageResult;
import com.go.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
public class SHotelServiceImpl extends ServiceImpl<SHotelMapper, SHotel> implements ISHotelService {

    @Autowired
    private HotelSkuVMapper hotelSkuVMapper;

    @Autowired
    private SHotelMapper sHotelMapper;

    @Autowired
    private SHotelskuMapper sHotelskuMapper;


    //分页条件查询酒店信息
    @Override
    public PageResult<HotelSkuV> searchHotelByPage(Integer page, Integer limit,HotelSkuV hotelSkuV) {
        Page<HotelSkuV> page1 = new Page<>(page, limit);
        QueryWrapper<HotelSkuV> qw = new QueryWrapper<>();
        if(!StringUtils.isEmpty(hotelSkuV.getHotelName())){
            qw.eq("hotel_name",hotelSkuV.getHotelName());
        }
        if(!StringUtils.isEmpty(hotelSkuV.getSiteId())){
            qw.eq("site_id",hotelSkuV.getSiteId());
        }
        if(!StringUtils.isEmpty(hotelSkuV.getUserId())){
            qw.eq("user_id",hotelSkuV.getUserId());
        }
        Page<HotelSkuV> hotelSkuVPage = hotelSkuVMapper.selectPage(page1, qw);

        return new PageResult<HotelSkuV>(hotelSkuVPage.getRecords(),hotelSkuVPage.getTotal());
    }

    //查询所有的酒店信息
    @Override
    public List<HotelSkuV> findAllHotel() {
        //查询所有的酒店
        QueryWrapper<HotelSkuV> qw = new QueryWrapper<>();
        List<HotelSkuV> sHotels = hotelSkuVMapper.selectList(qw);
        return sHotels;
    }

    //添加酒店
    @Override
    public Result saveHotel(SHotel sHotel) {

        //添加酒店主表
        String hotelId= UUID.randomUUID().toString();
        sHotel.setHotelId(hotelId);
        sHotelMapper.insert(sHotel);

        //添加酒店套餐
        List<SHotelsku> hotelskus = sHotel.getHotelSkus();
        for (SHotelsku sHotelsku : hotelskus) {
            sHotelsku.setHotelId(hotelId);
            sHotelskuMapper.insert(sHotelsku);
        }

        return new Result(true,"添加酒店成功");
    }




}
