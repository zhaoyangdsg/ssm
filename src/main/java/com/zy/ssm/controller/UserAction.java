package com.zy.ssm.controller;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.zy.ssm.domain.User;
import com.zy.ssm.service.IUserService;
import com.zy.ssm.service.IUserService.RegistResult;
import com.zy.ssm.util.UploadUtil;

@Controller
@RequestMapping("/user")
public class UserAction {

	@Resource 
	IUserService userService;
	
	@ResponseBody
	@RequestMapping("/login")
	public Object login(String mobile,String password,ModelAndView model,HttpServletRequest request) {
		System.out.println("user+password"+mobile+password);
//		 User userItem = this.userService.getUserById("1");
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("success", "false");
		 User userItem = this.userService.getUserByMobile(mobile);
		 if (userItem != null) {
			 if (StringUtils.hasText(userItem.getPassword()) && userItem.getPassword().equals(password)) {
				 userItem.setLastLoginDate(new Date());
				 userService.updateUser(userItem);
				 result.put("success", "true");
				 result.put("user", userItem);
			 }else {
				 result.put("error", "wrong password");
			 }
		 }else {
			 result.put("error", "no user");
		 }
		 
		 if("POST".equals(request.getMethod())) {
			 return JSON.toJSON(result);
		 }
		return null;
	}
	
	@ResponseBody
	@RequestMapping("/regist")
	public Object regist(ModelAndView model,HttpServletRequest request) throws UnsupportedEncodingException {
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("success", false);
		
		String name = request.getParameter("name");
		String nickName = request.getParameter("nickName");
		String avater = request.getParameter("avater");
		String password = request.getParameter("password");
		String mobile = request.getParameter("mobile");
		
		User user  = new User();
		user.setAvater(avater);
		user.setName(name);
		user.setNickName(nickName);
		user.setPassword(password);
		user.setMobile(mobile);
		user.setCreateDate(new Date());
		user.setStatus(1);
		System.out.println(user.toString());
		RegistResult r = userService.registUser(user);
		switch (r) {
			case SUCCESS:
				System.out.println("");
				result.put("success", true);
				break;
			case FAILURE:
				System.out.println();
				result.put("error", "regist fail");
				break;
			case EXSIT:
				System.out.println();;
				result.put("error", "mobile exsit");
				break;
		}
		
		if ("POST".equals(request.getMethod())) {
			return JSON.toJSON(result);
		}
		
		return null;
	}
	
	@RequestMapping("/uploadAvater")
	public Object uploadAvater(ModelAndView model,HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("success", false);
		Long userId = Long.valueOf(request.getParameter("userId"));
		String password = request.getParameter("password");
		if (userService.uploadAvater(request, userId, password)) {
			result.put("success", true);
		}
		if ("POST".equals(request.getMethod())) {
			return JSON.toJSON(result);
		}
		return null;
	}
}
