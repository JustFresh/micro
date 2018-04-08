package om.xiudoua.study.micro.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultiplController {

	@Value("${server.port}")
    private String port;
    
    @Value("${spring.cloud.client.ipAddres}")
    private String host;
    
    /**
     *提供计算两个数乘积的方法
     * @param a
     * @param b
     * @return
     */
    @RequestMapping(value = "/multiplyTwoNum",method = RequestMethod.GET)
    public String multiplyTwoNumGet(@RequestParam Integer a,@RequestParam Integer b){
        
        String res = "";
        res += "访问主机：" + host + " 端口：" + port;
        res += " 计算结果为：" + (a * b);
        return res;
        
    }
	
}
