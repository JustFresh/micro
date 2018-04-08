package com.xiudoua.study.micro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xiudoua.study.micro.entity.SshUser;

@Repository
public interface IUserDao extends JpaRepository<SshUser, String>{

	/**
	 * 模拟通过HQL传入用户状态的形式查询用户数据列表
	 * @param uStatus
	 * @return
	 */
	@Query("from SshUser c where c.uStatus=:uStatus")
	public List<SshUser> getListByHql(@Param("uStatus") int uStatus);
	
	@Query("from SshUser c where c.uId=:uId")
	public SshUser getOneById(@Param("uId")int uId);
	
}