package com.zy.ssm.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zy.ssm.dao.ICommentDao;
import com.zy.ssm.dao.IMomentDao;
import com.zy.ssm.domain.Comment;
import com.zy.ssm.domain.Moment;
import com.zy.ssm.service.IMomentService;

@Service
public class MomentServiceImpl implements IMomentService {

	@Resource
	IMomentDao momentDao;
	
	@Resource
	ICommentDao commentDao;
	
	@Override
	public List<Moment> getMoments(Long id) {
		List<Moment> moments = momentDao.getMomentsByUserId(id);
		System.out.println(moments.size());
		if (moments.size() >0) {
			return moments;
		}
		return null;
	} 
	
	public Map<String,Object> getDetailMomentById(Long id) {
		Moment moment = momentDao.getMomentDetailById(id);
		List<Comment> comments = commentDao.getCommentsByMomentId(id);
		
		
		return null;
	}
	
}
