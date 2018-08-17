package com.zy.ssm.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.zy.ssm.domain.Comment;

@MapperScan
public interface ICommentDao {
	List<Comment> getCommentsByMomentId(Long id);
}
