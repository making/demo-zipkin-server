package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(-10)
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatchers() //
                .mvcMatchers("/api/v1/**") //
                .and() //
                .authorizeRequests() //
                .anyRequest() //
                .authenticated() //
                .and() //
                .httpBasic();
    }
}