package com.zy.ssm.service.impl;

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
	public User getUserById(String id) {
		User user = userDao.getUserById(id);
//		System.out.println(user.toString());
		if (user != null) {
			return user;
		}
		return null;
	}

}
