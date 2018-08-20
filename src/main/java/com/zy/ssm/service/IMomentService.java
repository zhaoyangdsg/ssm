package com.zy.ssm.service;

import java.util.List;

import com.zy.ssm.domain.Moment;

public interface IMomentService {
	List<Moment> getMoments(Long id);
	
	boolean addMoment(Moment moment);
}
