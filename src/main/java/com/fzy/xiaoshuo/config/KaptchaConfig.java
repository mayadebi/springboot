package com.fzy.xiaoshuo.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;
// 验证码配置类
@Configuration
public class KaptchaConfig {
    @Bean
    public DefaultKaptcha producer() {
        Properties properties = new Properties();
        // 是否有边框
        properties.put("kaptcha.border", "no");
        // 文本颜色
        properties.put("kaptcha.textproducer.font.color", "black");
        // 每个字符空行
        properties.put("kaptcha.textproducer.char.space", "4");
        // 高度
        properties.put("kaptcha.image.height", "40");
        // 宽度
        properties.put("kaptcha.image.width", "120");
        // 字体大小
        properties.put("kaptcha.textproducer.font.size", "30");
        Config config = new Config(properties);
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}