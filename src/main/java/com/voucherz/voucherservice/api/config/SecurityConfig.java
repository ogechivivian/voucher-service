package com.voucherz.voucherservice.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Bean
//    public JwtAuthenticationFilter jwtAuthenticationFilter(){
//        return new JwtAuthenticationFilter();
//    }
    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
            .cors()
            .and()
            .csrf()
            .disable();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests()
            .antMatchers( )
            .permitAll()
            .anyRequest()
            .authenticated();

        //add our custom JWT security filter
        http.apply(new JwtFilterConfig());

    }

}
