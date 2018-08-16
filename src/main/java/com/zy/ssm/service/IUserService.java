package com.zy.ssm.service;

import javax.servlet.http.HttpServletRequest;

import com.zy.ssm.domain.User;
public interface IUserService {
	public enum RegistResult{SUCCESS,EXSIT,FAILURE}
	User getUserById(Long id);
	
	User getUserByMobile(String id);
	
	RegistResult registUser(User user);
	
	Boolean updateUser(User user);
	
	boolean uploadAvater(HttpServletRequest request);
	
	boolean checkUser(Long id,String password);
	
	boolean followUser(Long followedId,Long userId);
}
