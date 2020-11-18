package com.go.route.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.go.other.Comment;
import com.go.route.mapper.CommentMapper;
import com.go.route.service.ICommentService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-11-18
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

}
