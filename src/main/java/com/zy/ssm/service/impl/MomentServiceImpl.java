package com.zy.ssm.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.zy.ssm.dao.ICommentDao;
import com.zy.ssm.dao.IMomentDao;
import com.zy.ssm.domain.Comment;
import com.zy.ssm.domain.Moment;
import com.zy.ssm.domain.User;
import com.zy.ssm.service.IMomentService;
import com.zy.ssm.service.IUserService;
import com.zy.ssm.util.UploadUtil;

@Service
public class MomentServiceImpl implements IMomentService {

	@Resource
	IMomentDao momentDao;

	@Resource
	ICommentDao commentDao;

	@Resource
	IUserService userService;

	@Override
	public List<Moment> getMomentsByUserId(Long id) {
		List<Moment> moments = momentDao.getMomentsByUserId(id);
		System.out.println(moments.size());
		if (moments.size() > 0) {
			return moments;
		}
		return null;
	}

	public Map<String, Object> getDetailMomentById(Long id) {
		Moment moment = momentDao.getMomentDetailById(id);
		List<Comment> comments = commentDao.getCommentsByMomentId(id);

		return null;
	}

	public boolean addMoment(HttpServletRequest request, Moment moment) {

		Long userId = Long.valueOf(moment.getUserId());
		if (userId != null && moment.getContent() != null) {
			String fileName = UploadUtil.uploadFileWithName(request, "pic");
			User user = userService.getUserById(userId);
			moment.setUserAvatar(user.getAvatar());
			moment.setUserName(user.getName());
			moment.setCreateDate(new Date());
			if (moment.getContent() != null && moment.getContent().length() > 100) {
				moment.setShortContent(moment.getContent().substring(0, 100));
			} else if (moment.getContent() != null && moment.getContent().length() <= 100) {
				moment.setShortContent(moment.getContent());
			}
			if (fileName != null) {
				moment.setImgs(fileName);
			}
			if (momentDao.addMoment(moment) > 0) {
				return true;
			}
		}

		return false;
	}

	@Override
	public Moment getMomentById(Long id) {
		Moment moment = momentDao.getMomentDetailById(id);
		if (moment != null) {
			return moment;
		}
		return null;
	}

	@Override
	public void addTest() {

	}

}
