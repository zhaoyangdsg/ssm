package com.zy.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zy.ssm.dao.IMomentDao;
import com.zy.ssm.domain.Moment;
import com.zy.ssm.service.IMomentService;

@Service
public class MomentServiceImpl implements IMomentService {

	@Resource
	IMomentDao momentDao;
	
	@Override
	public List<Moment> getMoments(Long id) {
		List<Moment> moments = momentDao.getMomentByUserId(id);
		System.out.println(moments.size());
		if (moments.size() >0) {
			return moments;
		}
		return null;
	} 
	
	
}
