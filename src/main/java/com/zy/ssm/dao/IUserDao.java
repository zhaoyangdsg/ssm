package com.zy.ssm.dao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import com.zy.ssm.domain.Follow;
import com.zy.ssm.domain.User;

//@MapperScan
@Repository
public interface IUserDao {
	User getUserById(Long id);
	User getUserByName(String name);
	int addUser(User user);
	int updateUser(User user);
	int deleteUser(Long id);
	User getUserByMobile(String mobile);
	int followUser(Follow follow);
	int cancelFollow(Follow follow);
	
	int checkFollow(Follow follow);
}
