package com.xiudoua.study.micro.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddController {

	@RequestMapping(value = "/addTwoNum",method = RequestMethod.GET)
    public String addTowNum(@RequestParam Integer a,@RequestParam Integer b){
        return "公用调用a+b方法返回结果为：" + (a + b);
    }
	
}
