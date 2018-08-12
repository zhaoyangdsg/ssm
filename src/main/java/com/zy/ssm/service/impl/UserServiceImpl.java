package com.zy.ssm.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.zy.ssm.dao.IUserDao;
import com.zy.ssm.domain.User;
import com.zy.ssm.service.IUserService;
import com.zy.ssm.util.UploadUtil;

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
		if (userDao.getUserByMobile(user.getMobile()) == null) {
			int row = userDao.addUser(user);
			if (row > 0) {
				return RegistResult.SUCCESS;
			} else {
				return RegistResult.FAILURE;
			}
		}
		return RegistResult.EXSIT;
	}

	public Boolean updateUser(User user) {

		int row = userDao.updateUser(user);
		if (row > 0) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean deleteUser(User user) {
		int row = userDao.deleteUser(user.getId());
		if (row > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean uploadAvater(HttpServletRequest request, Long userId, String password) {
		// 密码不为空
		if (StringUtils.hasText(password)) {
			User user = userDao.getUserById(userId);
			if (StringUtils.hasText(user.getPassword()) && password.equals(user.getPassword())) {
				String fileName = UUID.randomUUID().toString() + ".jpg";
				boolean isOK = UploadUtil.uploadFile(request, fileName);
				if (isOK) {
					user.setAvater(fileName);
					userDao.updateUser(user);
					return true;
				}

			}
		}
		return false;
	}

}
