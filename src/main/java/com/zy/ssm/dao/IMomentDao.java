package com.zy.ssm.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.zy.ssm.domain.Moment;

@MapperScan
public interface IMomentDao {
	List<Moment> getMomentsByUserId(Integer id);
	
	Moment getMomentDetailById(Integer id);
	
	int addMoment(Moment moment);
	
	int updateMoment(Moment moment);
	
	int zanMoment(Integer momentId,Integer userId);
	
	int cacelZanMoment(Integer momentId,Integer userId);
}
