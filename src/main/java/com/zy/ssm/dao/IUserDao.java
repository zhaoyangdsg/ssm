package com.zy.ssm.dao;

import org.mybatis.spring.annotation.MapperScan;

import com.zy.ssm.domain.User;

@MapperScan
public interface IUserDao {
	User getUserById(Long id);
	User getUserByName(String name);
	int addUser(User user);
	int updateUser(User user);
	int deleteUser(Long id);
	User getUserByMobile(String mobile);
	
}
