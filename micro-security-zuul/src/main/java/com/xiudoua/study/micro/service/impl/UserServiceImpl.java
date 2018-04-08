package com.xiudoua.study.micro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiudoua.study.micro.dao.SysUserRepository;
import com.xiudoua.study.micro.entity.SysUser;
import com.xiudoua.study.micro.service.IUserService;
import com.xiudoua.study.micro.utils.MD5Util;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService{

	@Autowired
    SysUserRepository userRepository;
	
	@Override
	public SysUser findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public SysUser create(SysUser param) {
		//进行加密
        BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
        param.setPassword(encoder.encode(MD5Util.encode(param.getPassword().trim())));
        userRepository.save(param);
	    return param;
	}

}