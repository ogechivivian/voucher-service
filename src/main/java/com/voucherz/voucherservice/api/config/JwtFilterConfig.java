package com.voucherz.voucherservice.api.config;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtFilterConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>{

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception{
        JwtAuthenticationFilter filter = new JwtAuthenticationFilter();
        httpSecurity.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

    }
}
