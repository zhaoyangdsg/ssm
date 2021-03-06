package com.zy.ssm.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public Object login(String mobile, String password, ModelAndView model, HttpServletRequest request) {
		System.out.println("user+password" + mobile + password);
		// User userItem = this.userService.getUserById("1");
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", "false");
		User userItem = this.userService.getUserByMobile(mobile);
		if (userItem != null) {
			if (StringUtils.hasText(userItem.getPassword()) && userItem.getPassword().equals(password)) {
				userItem.setLastLoginDate(new Date());
				userService.updateUser(userItem);
				result.put("success", "true");
				result.put("user", userItem);
			} else {
				result.put("error", "wrong password");
			}
		} else {
			result.put("error", "no user");
		}

		if ("POST".equals(request.getMethod())) {
			return JSON.toJSON(result);
		}
		return null;
	}

	@ResponseBody
	@RequestMapping("/regist")
	public Object regist(ModelAndView model, HttpServletRequest request) throws UnsupportedEncodingException {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", false);

		String name = request.getParameter("name");
		String nickName = request.getParameter("nickName");
		String avatar = request.getParameter("avatar");
		String password = request.getParameter("password");
		String mobile = request.getParameter("mobile");

		User user = new User();
		user.setAvatar(avatar);
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
			System.out.println();
			;
			result.put("error", "mobile exsit");
			break;
		}

		if ("POST".equals(request.getMethod())) {
			return JSON.toJSON(result);
		}

		return null;
	}

	@ResponseBody
	@RequestMapping("/uploadAvater")
	public Object uploadAvater(ModelAndView model, HttpServletRequest request, User user) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", false);
		Integer id =  Integer.valueOf(user.getId());
		String password = user.getPassword();
		if (userService.checkUser(id, password)) {
			String fileName = UploadUtil.uploadFileWithName(request, "pic");
			if (fileName != null) {
				User user1 = userService.getUserById(id);
				user1.setAvatar(fileName);
				if (userService.updateUser(user1)) {
					result.put("success", true);
				}
			}
		}
		if ("POST".equals(request.getMethod())) {
			return JSON.toJSON(result);
		}
		return null;
	}
	
	
	@ResponseBody
	@RequestMapping("/updateUser")
	public Object updateUserInfo(HttpServletRequest request,User user) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", false);
		if (userService.getUserById(user.getId()) != null ) {
			if ( userService.updateUser(user)) {
				result.put("success", true);
			}
		}
		if ("POST".equals(request.getMethod())) {
			return JSON.toJSON(result);
		}
		
		return null;
	}
	
	@ResponseBody
	@RequestMapping("/follow")
	public Object follow(HttpServletRequest request, String followedId,String userId) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", false);
		if (StringUtils.hasText(userId)&&StringUtils.hasText(followedId) && followedId != userId) {
			Integer l_userId = Integer.valueOf(userId);
			Integer l_followedId = Integer.valueOf(followedId);
			if (userService.getUserById(l_userId) != null && userService.getUserById(l_followedId) != null ) {
				if ( userService.followUser(l_followedId, l_userId)) {
					result.put("success", true);
				}
			}
		}
		
		if ("POST".equals(request.getMethod())) {
			return JSON.toJSON(result);
		}
		
		return null;
	}
}
