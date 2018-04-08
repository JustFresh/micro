package com.xiudoua.study.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication extends SpringBootServletInitializer{

	//1.默认jar启动方式
	/*public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }*/
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(EurekaApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
	
}
