package com.zy.ssm.domain;

import java.util.Date;

public class Comment {
	private Long id;
	private Long userId;
	private String content;
	private Date createDate;
	public Comment(Long id, Long userId, String content, Date createDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.content = content;
		this.createDate = createDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", userId=" + userId + ", content=" + content + ", createDate=" + createDate + "]";
	}
	
	
}
