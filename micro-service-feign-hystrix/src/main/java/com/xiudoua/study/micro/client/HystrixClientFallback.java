package com.xiudoua.study.micro.client;

import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallback implements MultiplFeignHystrixClient{

    @Override
    public String multiplyTwoNum(Integer a, Integer b) {
        return "断路器效果成功！";
    }

}
