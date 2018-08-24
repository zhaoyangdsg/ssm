package com.zy.ssm.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zy.ssm.domain.Moment;

public interface IMomentService {
	List<Moment> getMomentsByUserId(Long id);
	
	boolean addMoment(HttpServletRequest request,Moment moment) ;
	
	Moment getMomentById(Long id);
	
	void addTest();
}
