package com.xiudoua.study.micro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CallFeignController {

	@Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    
    @RequestMapping(value = "/zipkinCall", method = RequestMethod.GET)
    public String testFeign(Model model) {
        return restTemplate.getForObject("http://localhost:8087/testFeign",String.class);
    }
	
}