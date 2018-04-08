package com.xiudoua.study.micro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xiudoua.study.micro.entity.SysUser;

@Repository
public interface SysUserRepository extends JpaRepository<SysUser, Long>{

	SysUser findByUsername(String username);
	
}