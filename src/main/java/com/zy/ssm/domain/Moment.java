package com.zy.ssm.domain;

import java.util.Date;

public class Moment {
	private Integer id;
	private Integer userId;
	private String userAvatar;
	private String userName;
	private String imgs;
	private String content;
	private String shortContent;
	private Integer zanNum;
	private Integer commentNum;
	private String position;
	private Date createDate;
	//private List<Comment> comments;
//	private User user;

	public Moment() {
		super();
		
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getUserId() {
		return userId;
	}



	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	public String getImgs() {
		return imgs;
	}
	public void setImgs(String imgs) {
		this.imgs = imgs;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getZanNum() {
		return zanNum;
	}
	public void setZanNum(Integer zanNum) {
		this.zanNum = zanNum;
	}
	public Integer getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}


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

	public String getShortContent() {
		return shortContent;
	}

	public void setShortContent(String shortContent) {
		this.shortContent = shortContent;
	}

	@Override
	public String toString() {
		return "Moment [id=" + id + ", userId=" + userId + ", userAvatar=" + userAvatar + ", userName=" + userName
				+ ", imgs=" + imgs + ", content=" + content + ", shortContent=" + shortContent + ", zanNum=" + zanNum
				+ ", commentNum=" + commentNum + ", position=" + position + ", createDate=" + createDate + ", comments="+  "]";
	}
	
	
}
