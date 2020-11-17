package com.go.route.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.go.other.Tag;
import com.go.route.mapper.TagMapper;
import com.go.route.service.ITagService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-11-17
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {

}
