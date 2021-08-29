package com.fzy.xiaoshuo.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

// 自动填充配置
@Slf4j
@Component
public class MyDataHandler implements MetaObjectHandler {
//    插入时候的填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("crtDt",new Date(),metaObject);
        this.setFieldValByName("uptDt",new Date(),metaObject);
    }
//    更新时候的填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("uptDt",new Date(),metaObject);
    }
}
