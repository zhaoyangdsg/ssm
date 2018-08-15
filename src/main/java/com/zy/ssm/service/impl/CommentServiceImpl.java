package com.zy.ssm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zy.ssm.dao.ICommentDao;
import com.zy.ssm.service.ICommentService;

@Service
public class CommentServiceImpl implements ICommentService {

	
	@Resource
	ICommentDao commentDao;
}
