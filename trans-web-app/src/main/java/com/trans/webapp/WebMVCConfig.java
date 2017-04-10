package com.trans.webapp;

import com.trans.webapp.Interceptor.UserSecurityInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author mashaobo
 * @date 17/2/24
 * @blog http://blog.csdn.net/cnitihc0
 * @email cnitihc0@163.com
 */
@Configuration
//@EnableWebMvc//无需使用该注解，否则会覆盖掉SpringBoot的默认配置值
public class WebMVCConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new UserSecurityInterceptor()).addPathPatterns("/**").excludePathPatterns("/login.html");
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

}
