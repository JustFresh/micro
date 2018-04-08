package com.xiudoua.study.micro.service;

import com.xiudoua.study.micro.entity.SysUser;

public interface IUserService {

	SysUser findByUsername(String username);
	
	SysUser create(SysUser param);
	
}
