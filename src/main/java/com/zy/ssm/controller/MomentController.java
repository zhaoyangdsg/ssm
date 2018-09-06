package com.zy.ssm.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zy.ssm.domain.Moment;
import com.zy.ssm.domain.User;
import com.zy.ssm.service.IMomentService;
import com.zy.ssm.service.IUserService;
import com.zy.ssm.util.UploadUtil;

@Controller
@RequestMapping("/moment")
public class MomentController {

	@Resource
	IMomentService momentService;

	@Resource
	IUserService userService;

	@ResponseBody
	@RequestMapping("/momentsOfUser")
	public Object getUserMoment(HttpServletRequest request, String id) {
		System.out.println(id);
		List<Moment> moments = momentService.getMomentsByUserId(Integer.parseInt(id));
		if ("POST".equals(request.getMethod())) {
			return JSON.toJSONString(moments);
		}
		return null;
	}

	@RequestMapping("/momentZan")
	public Object zan(HttpServletRequest request, String userId, String momentId) {

		return null;
	}

	public Object cancelZan(HttpServletRequest request, String userId, String momentId) {

		return null;
	}

	public Object deleteMoment(HttpServletRequest request, String userId, String momentId) {

		return null;
	}

	@ResponseBody
	@RequestMapping("/postMoment")
	// 发动态
	public Object addMoment(HttpServletRequest request, Moment moment) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", false);
		if ( momentService.addMoment(request,moment)) {
			result.put("success", true);
		}
		if ("POST".equals(request.getMethod())) {
			return JSON.toJSON(result);
		}
		return null;
	}

	public Object updateMoment(HttpServletRequest request, Moment moment) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", false);
		if (moment.getId() != null && moment.getUserId() != null && moment.getContent() != null) {
			Integer id = Integer.valueOf(moment.getId());
			Moment m = momentService.getMomentById(id);
			if (m !=null) {
				
				if (moment.getContent() != null && moment.getContent().length() > 100) {
					m.setShortContent(moment.getContent().substring(0, 100));
				}else if (moment.getContent() != null && moment.getContent().length() <= 100) {
					m.setShortContent(moment.getContent());
				}
				m.setContent(moment.getContent());
			}
		}
		
		return null;
	}

}
