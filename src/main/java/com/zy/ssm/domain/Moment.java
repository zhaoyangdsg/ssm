package com.zy.ssm.domain;

import java.util.Date;
import java.util.List;

public class Moment {
	private Long id;
	private Long userId;
	private String imgs;
	private String content;
	private Integer zanNum;
	private Integer commentNum;
	private String position;
	private Date createDate;
	private List<Comment> comments;
	private User user;

	public Moment() {
		super();
		
	}
	
	
	
	public Moment(Long id, Long userId, String imgs, String content, Integer zanNum, Integer commentNum,
			String position, Date createDate, List<Comment> comments, User user) {
		super();
		this.id = id;
		this.userId = userId;
		this.imgs = imgs;
		this.content = content;
		this.zanNum = zanNum;
		this.commentNum = commentNum;
		this.position = position;
		this.createDate = createDate;
		this.comments = comments;
		this.user = user;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
