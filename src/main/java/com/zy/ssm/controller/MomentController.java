package com.zy.ssm.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zy.ssm.domain.Moment;
import com.zy.ssm.service.IMomentService;

@Controller
@RequestMapping("/moment")
public class MomentController {

	@Resource
	IMomentService momentService;
	
	@ResponseBody
	@RequestMapping("/momentsOfUser")
	public Object getUserMoment(HttpServletRequest request, String id) {
		System.out.println(id);
		List<Moment> moments = momentService.getMoments(Long.parseLong(id));
		System.out.println(JSON.toJSONString(moments));
		if ("POST".equals(request.getMethod())) {
			return JSON.toJSONString(moments);
		}
		return null;
	}
}
