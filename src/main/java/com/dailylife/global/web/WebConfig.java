package com.dailylife.global.web;

import com.dailylife.global.interceptor.JwtInterceptor;
import com.dailylife.global.interceptor.WebInterceptor;
import com.dailylife.global.jwt.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final JwtService jwtService;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new WebInterceptor()).
                order(1).
                addPathPatterns("/**").
                excludePathPatterns(
                        "/swagger-ui.html",
                        "/swagger-ui/**" ,
                        "/swagger-resources/**",
                        "/webjars/**",
                        "/api/users/join",
                        "/api/users/login"
                        ,"/error");

            registry.addInterceptor(new JwtInterceptor(jwtService)).
                    order(2).
                    addPathPatterns("/**").
                    excludePathPatterns(
                            "/swagger-ui.html",
                            "/swagger-ui/**" ,
                            "/swagger-resources/**",
                            "/webjars/**",
                            "/api/users/join",
                            "/api/users/login"
                            ,"/error");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
