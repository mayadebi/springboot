package com.fzy.xiaoshuo.service.impl;

import com.fzy.xiaoshuo.entity.Blog;
import com.fzy.xiaoshuo.dao.BlogMapper;
import com.fzy.xiaoshuo.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fzy
 * @since 2021-08-29
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
