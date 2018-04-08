package com.xiudoua.study.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.xiudoua.study.micro.entity","com.xiudoua.study.micro.controller","com.xiudoua.study.micro.service","com.xiudoua.study.micro.dao"})
@ServletComponentScan
public class JpaApplication {

	public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }
	
}