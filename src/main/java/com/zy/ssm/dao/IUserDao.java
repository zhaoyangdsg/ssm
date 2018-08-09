package com.zy.ssm.dao;

import org.mybatis.spring.annotation.MapperScan;

import com.zy.ssm.domain.User;

@MapperScan
public interface IUserDao {
	User getUserById(String id);
	User getUserByName(String name);
	int addUser(User user);
	int updateUserInfo(User user);
	int deleteUserInfoById(String id);
}
