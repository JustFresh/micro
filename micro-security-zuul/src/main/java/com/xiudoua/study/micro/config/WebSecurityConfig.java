package com.xiudoua.study.micro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.xiudoua.study.micro.security.CustomUserService;

@Configuration
@EnableGlobalMethodSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Bean
    UserDetailsService customUserService() {
        return new CustomUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {        
        http.authorizeRequests().anyRequest().authenticated()
        .and().formLogin().loginPage("/login").failureUrl("/login?error").permitAll()
        .and().logout().permitAll();
        
        http.logout().logoutUrl("/logout");// 指定Security登出请求
        http.csrf().disable();// 静态资源不支持CSFR（跨站请求伪造），故禁用CSFR
        http.authorizeRequests().antMatchers("/login.html", "/**/**.css", "/images/**", "**/**.js","/index").permitAll();// 对登录页面和相关静态资源免除登录认证
        http.authorizeRequests().antMatchers("/**").authenticated();// 所有请求均需要进行登录验证
        http.authorizeRequests().antMatchers("/user").hasRole("user");
        http.authorizeRequests().antMatchers("/admin").hasRole("admin");
        http.exceptionHandling().accessDeniedPage("/401");//没有权限页面声明
        http.httpBasic();// 开始Http基本认证
    }
	
}
