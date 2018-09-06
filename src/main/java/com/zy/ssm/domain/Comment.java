package com.zy.ssm.domain;

import java.util.Date;
import java.util.List;

public class Comment {
	private Integer id;
	private Integer parentId;
	private Integer userId;
	private String userAvatar;
	private String userName;
	private String content;
	private Date createDate;
	private List<Comment> commentsList;
	private User user;


	public Comment() {
		super();
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
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", userId=" + userId + ", content=" + content + ", createDate=" + createDate + "]";
	}
	public String getUserAvatar() {
		return userAvatar;
	}
	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<Comment> getCommentsList() {
		return commentsList;
	}
	public void setCommentsList(List<Comment> commentsList) {
		this.commentsList = commentsList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	
}
