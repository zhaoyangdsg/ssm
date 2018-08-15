package com.zy.ssm.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.zy.ssm.domain.Moment;

@MapperScan
public interface IMomentDao {
	List<Moment> getMomentByUserId(Long id);
}