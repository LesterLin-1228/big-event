package com.lesterlin.bigevent.config;

import com.lesterlin.bigevent.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 登入接口和註冊接口不攔截
        registry.addInterceptor(loginInterceptor).excludePathPatterns("/user/login","/user/register","/user/sendResetPwdMail");
    }
}
