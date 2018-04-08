package com.xiudoua.study.micro.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiudoua.study.micro.bean.Msg;

@Controller
public class UserController {

	@RequestMapping("/")
    public String root(Model model) {
        return "redirect:/index";
    }
    
    @RequestMapping(value = "/index")
    public String index(Model model) {
        Msg msg = new Msg("测试标题hand", "测试信息", "额外信息 ， 只对管理员显示");
        model.addAttribute("msg", msg);
        return "index";
    }
    
    @PreAuthorize("hasRole('ROLE_USER')")//配置角色权限
    @RequestMapping(value = "/user/index")
    public String userIndex(Model model) {
        return "user/index";
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")//配置角色权限
    @RequestMapping(value = "/admin/index")
    public String adminIndex(Model model) {
        return "admin/index";
    }
    
    @RequestMapping(value = "/login")
    public String login(Model model) {
        return "login";
    }
    
    @RequestMapping(value = "/logout")
    public String logout(Model model) {
        return "logout";
    }
    
    @RequestMapping(value = "/401")
    public String accessDenied(Model model) {
        return "401";
    }
	
}