package com.zy.ssm.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.json.JsonObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zy.ssm.domain.User;
import com.zy.ssm.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserAction {

	@Resource 
	IUserService userService;
	
	@ResponseBody
	@RequestMapping("/login")
	public void login(@RequestParam("user")String user,@RequestParam("password")String password,PrintWriter pw) {
		System.out.println("user+password"+user+password);
		 User userItem = this.userService.getUserById("1");
		 if (userItem != null) {
			 System.out.println(userItem.toString());
			 
			 pw.write(JSON.toJSONString(userItem));
		 }else {
			 System.out.println("null");
		 }
		 
		
//		 return userItem;
//		return "login";
	}
}
