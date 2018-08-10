package com.zy.ssm.service;

import com.zy.ssm.domain.User;
public interface IUserService {
	public enum RegistResult{SUCCESS,EXSIT,FAILURE}
	User getUserById(Long id);
	
	User getUserByMobile(String id);
	
	RegistResult registUser(User user);
	
	Boolean updateUser(User user);
}
