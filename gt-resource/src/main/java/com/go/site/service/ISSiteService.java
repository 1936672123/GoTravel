package com.go.site.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.go.site.SSite;
import com.go.vo.Result;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2020-11-17
 */
public interface ISSiteService extends IService<SSite> {

    public SSite descSearch(Integer siteId);

    public List<String> hotSearch();

    public Result createSite(@RequestBody SSite sSite);

    public Result deleteSite(Integer siteId);


}
