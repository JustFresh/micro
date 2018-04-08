package com.xiudoua.study.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@ComponentScan(basePackages={"com.xiudoua.study.micro.entity","com.xiudoua.study.micro.config","com.xiudoua.study.micro.dao","com.xiudoua.study.micro.security","com.xiudoua.study.micro.service.impl","com.xiudoua.study.micro.filter"})
@EnableZuulProxy
@SpringBootApplication
public class SecurityZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityZuulApplication.class, args);
	}
	
}