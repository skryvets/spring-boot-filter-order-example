package com.example.springfiltertutorial;

import com.example.springfiltertutorial.filter.DoNothingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
public class MyAppConfiguration {

    @Bean
    FilterRegistrationBean<DoNothingFilter> registrationBean() {
        final FilterRegistrationBean<DoNothingFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new DoNothingFilter());
        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);

        return registrationBean;
    }
}
