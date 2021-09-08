package com.fzy.xiaoshuo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SeucrityContig extends WebSecurityConfigurerAdapter {

    private static final String[] URL_WHITELIST = {
            "/login",
            "/logout",
            "/captcha",
            "/favicon.ico"
    };

    protected void configure(HttpSecurity http) throws Exception {
        // 预防攻击的关闭
        http.cors().and().csrf().disable()
                // 登录配置
                .formLogin()
//                .successHandler()
//                .failureHandler()
                // 禁用session
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                // 拦截规则
                .and()
                .authorizeRequests()
                .antMatchers(URL_WHITELIST).permitAll()
                .anyRequest().authenticated()
        // 异常处理器

        // 配置自定义过滤器
        ;
    }
}
