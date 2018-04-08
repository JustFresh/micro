package com.xiudoua.study.micro.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiudoua.study.micro.bean.UserBean;
import com.xiudoua.study.micro.dao.IUserDao;
import com.xiudoua.study.micro.entity.SshUser;
import com.xiudoua.study.micro.exception.FormException;
import com.xiudoua.study.micro.service.IUserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	@Override
	public int add(UserBean param) throws FormException {
		if(param.getUsername() == null || "".equals(param.getUsername().trim())){
            throw new FormException("101","请输入用户名");
        }
		if(param.getPassword() == null || "".equals(param.getPassword())){
			throw new FormException("101","请输入密码");
		}
		//param.setId(UUIDTool.getUUID());
		param.setuStatus(1);
		param.setCreateTime(new Date());
		SshUser user = new SshUser();
        BeanUtils.copyProperties(param, user);
        SshUser res = this.userDao.save(user);
        if(res != null){
            return 1;
        }
        return 0;
	}

	@Override
	public int remove(UserBean param) throws FormException {
		if(param.getuId() <= 0){
            throw new FormException("101","请选择需要删除的数据");
        }
        //逻辑删除
		SshUser user = this.userDao.getOneById(param.getuId());
        if(user != null){
            user.setuStatus(0);
            SshUser res = this.userDao.saveAndFlush(user);
            if(res != null){
                //逻辑删除成功
                return 1;
            }
        }
        return 0;
	}

	@Override
	public UserBean update(UserBean param) throws FormException {
		if(param.getuId() <= 0){
            throw new FormException("101","请选择需要修改的数据");
        }
		SshUser user = this.userDao.getOneById(param.getuId());
        BeanUtils.copyProperties(param, user);
        if(user != null){
        	user.setCreateTime(new Date());
        	SshUser res = this.userDao.saveAndFlush(user);
            if(res != null){
                BeanUtils.copyProperties(res, param);
                return param;
            }
        }
        return null;
	}

	@Override
	public UserBean getOne(UserBean param) throws FormException {
		if(param.getuId() <= 0){
            throw new FormException("101","请选择需要查询的数据");
        }
		SshUser user = this.userDao.getOneById(param.getuId());
        if(user != null){
            UserBean result = new UserBean();
            BeanUtils.copyProperties(user, result);
            return result;
        }
        return null;
	}

	@Override
	public List<UserBean> getList(UserBean param) throws FormException {
		List<SshUser> list = this.userDao.getListByHql(1);//查询状态值为1的用户数据
        if(list != null && list.size() > 0){
            List<UserBean> userList = new ArrayList<UserBean>();
            for(SshUser user : list){
                UserBean bean = new UserBean();
                BeanUtils.copyProperties(user, bean);
                userList.add(bean);
            }
            return userList;
        }
        return null;
	}

}
