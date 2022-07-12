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

    @Bean
    public FilterRegistrationBean getFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new CorsFilter());
        registrationBean.setOrder(Integer.MIN_VALUE);
        registrationBean.addUrlPatterns("/*");
//        registrationBean.setUrlPatterns(Arrays.asList("/board/*"));
        return registrationBean;
    }


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

//        registry.addInterceptor(new WebInterceptor()).
//                order(1).
//                addPathPatterns("/**").
//                excludePathPatterns(
//                        "/swagger-ui.html",
//                        "/swagger-ui/**" ,
//                        "/swagger-resources/**",
//                        "/webjars/**",
//                        "/api/users/join",
//                        "/api/users/login"
//                        ,"/error");

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
                            "/api/users/joinTest",
                            "/api/users/loginTest"
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
