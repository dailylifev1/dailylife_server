package com.dailylife.global.web;


import com.dailylife.global.interceptor.JwtInterceptor;
import com.dailylife.global.interceptor.WebInterceptor;
import com.dailylife.global.jwt.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import java.util.Arrays;

@Configuration
@EnableWebMvc
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    public static final String ALLOWED_METHOD_NAMES = "GET,HEAD,POST,PUT,DELETE,TRACE,OPTIONS,PATCH";
    private final JwtService jwtService;

    /**
     * Cors 문제 해결 설정
     */

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedOriginPatterns("*")
                .allowedHeaders("*")
                .exposedHeaders("*")
                .allowedMethods(ALLOWED_METHOD_NAMES.split(","));
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

            registry.addInterceptor(new JwtInterceptor(jwtService)).
                    order(1).
                    addPathPatterns("/**").
                    excludePathPatterns(
                            "/swagger-ui.html",
                            "/swagger-ui/**" ,
                            "/swagger-resources/**",
                            "/webjars/**",
                            "/api/users/join",
                            "/api/users/login",
                            "/error",
                            "/boardImg/**",
                            "/api/board/getBoardCount",
                            "/api/heart/countHeartReply/**",
                            "/api/heart/countHeartBoard/**"
                    ,"/api/board/getBoardNotLogin","/api/comment/getComment/**");


    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        registry.addResourceHandler("/boardImg/**")
                .addResourceLocations("file:////home/ubuntu/images/");
    }
}
