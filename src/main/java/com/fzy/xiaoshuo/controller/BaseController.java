package com.fzy.xiaoshuo.controller;

import com.fzy.xiaoshuo.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {
    @Autowired
    HttpServletResponse resp;
    @Autowired
    HttpServletRequest req;
    @Autowired
    RedisUtils redisUtils;
}
