package com.xiudoua.study.micro.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.xiudoua.study.micro.entity.SysRole;
import com.xiudoua.study.micro.entity.SysUser;
import com.xiudoua.study.micro.service.IUserService;

@Service("uService")
public class CustomUserService implements UserDetailsService{

	@Autowired
    IUserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(CustomUserService.class);
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在!");
        }
        
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        //用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
        for(SysRole role:user.getRoles()){
            authorities.add(new SimpleGrantedAuthority(role.getName()));
            logger.info("loadUserByUsername: " + user);
        }
        System.out.println("用戶拥有如下角色：");
        System.out.println(user.getAuthorities());
        return user;
    }
	
}
