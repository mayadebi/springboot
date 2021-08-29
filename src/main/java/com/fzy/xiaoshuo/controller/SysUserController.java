package com.fzy.xiaoshuo.controller;


import com.fzy.xiaoshuo.common.Result;
import com.fzy.xiaoshuo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fzy
 * @since 2021-08-29
 */
@RestController
@RequestMapping("/xiaoshuo/sys-user")
public class SysUserController {
    @Autowired
    SysUserService sysUserService;
    @GetMapping("/{id}")
    public Object test(@PathVariable("id") Long id) {
        return Result.success(200,"操作成功",sysUserService.getById(id)) ;
    }

}

