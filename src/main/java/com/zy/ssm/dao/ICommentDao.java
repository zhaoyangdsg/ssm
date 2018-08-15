package com.zy.ssm.dao;

import org.mybatis.spring.annotation.MapperScan;

import com.zy.ssm.domain.Comment;

@MapperScan
public interface ICommentDao {
	Comment getCommentsByMomentId(Long id);
}
