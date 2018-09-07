package com.zy.ssm.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zy.ssm.domain.Moment;

public interface IMomentService {
	List<Moment> getMomentsByUserId(Integer id);
	
	boolean addMoment(HttpServletRequest request,Moment moment) ;
	
	Moment getMomentById(Integer id);
	
	boolean zanMoment(Integer momentId,Integer userId);
	
	boolean cancelZanMoment(Integer momentId,Integer userId);
	
	void addTest();
	
	boolean deleteMomoent(Integer momentId,Integer userId);
}
