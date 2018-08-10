package com.zy.ssm.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zy.ssm.dao.IUserDao;
import com.zy.ssm.domain.User;
import com.zy.ssm.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Resource
	IUserDao userDao;
	
	@Override
	public User getUserById(Long id) {
		User user = userDao.getUserById(id);
		if (user != null) {
			return user;
		}
		return null;
	}
	@Override
	public User getUserByMobile(String mobile) {
		User user = userDao.getUserByMobile(mobile);
		if (user != null) {
			return user;
		}
		return null;
	}
	@Override
	public RegistResult registUser(User user) {
		if ( userDao.getUserByMobile(user.getMobile()) == null) {
			int row = userDao.addUser(user); 
			if (row >0) {
				return RegistResult.SUCCESS;
			}else {
				return RegistResult.FAILURE;
			}
		}
		return RegistResult.EXSIT;
	}
	
	public Boolean updateUser(User user) {
		
		int row = userDao.updateUser(user);
		if (row >0) {
			return true;
		}else {
			return false;
		}
	}
	
	public Boolean deleteUser(User user) {
		int row = userDao.deleteUser(user.getId());
		if (row >0) {
			return true;
		}else {
			return false;
		}
	}

}
