package com.example.studyVue.intercepter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author: z6~
 * @time: 2019-10-16 11:56
 */
@Configuration
public class BaseInterceptor extends WebMvcConfigurationSupport {

    @Autowired
    private TokenInterceptor tokenInterceptor;

    /**
     * 添加拦截器
     */
    protected void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(tokenInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/",
//                        "/login/**","/banner/**","/error")
//                .excludePathPatterns("/test/**")
//                .excludePathPatterns("/z_a");
        super.addInterceptors(registry);
    }
}
