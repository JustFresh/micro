package com.xiudoua.study.micro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xiudoua.study.micro.client.MultiplFeignHystrixClient;

@RestController
public class FeignController {

	@Autowired
    private MultiplFeignHystrixClient multiplFeignClient;
    
    @RequestMapping(value = "/multiplyTwoNum", method = RequestMethod.GET)
    public String multiplyTwoNum(@RequestParam Integer a, @RequestParam Integer b) {
        String string = this.multiplFeignClient.multiplyTwoNum(a, b);
        return string;
    }
    
    @RequestMapping(value = "/testFeign", method = RequestMethod.GET)
    public String testFeign(Model model) {
        return "feign客户端正常启动！";
    }
	
}
