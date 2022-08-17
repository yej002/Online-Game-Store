package com.jing.storeweb.config;

import com.jing.storeweb.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * This class defined web address that no need to go through login interceptor
 * In other words, no need to log in to view the page.
 */
@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        HandlerInterceptor interceptor = new LoginInterceptor();
        // list the address that should not be blocked if not logged in
        List<String> patterns = new ArrayList<>();
        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("/images/**");
        patterns.add("/js/**");
        patterns.add("/web/register.html");
        patterns.add("/web/login.html");
        patterns.add("/web/index.html");
        patterns.add("/web/product.html");
        patterns.add("/users/reg");
        patterns.add("/users/login");
        patterns.add("/districts/**");
        patterns.add("/products/**");
// registry will use interceptor to block addresses which exclude above listed addresses
        registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns(patterns);
    }
}

