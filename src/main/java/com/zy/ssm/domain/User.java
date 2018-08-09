package com.zy.ssm.domain;

import java.util.Date;

public class User {
	private Long id;
	private String name;
	private String nickName;
	private String password;
	private String avater;
	private String mobile;
	private Date createDate ;
	private Date lastLoginDate ;
	private Integer status;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAvater() {
		return avater;
	}
	public void setAvater(String avater) {
		this.avater = avater;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	

	public User() {
		super();
	}
	public User(Long id, String name, String nickName, String password, String avater, String mobile, Date createDate,
			Date lastLoginDate, Integer status) {
		super();
		this.id = id;
		this.name = name;
		this.nickName = nickName;
		this.password = password;
		this.avater = avater;
		this.mobile = mobile;
		this.createDate = createDate;
		this.lastLoginDate = lastLoginDate;
		this.status = status;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", nickName=" + nickName + ", password=" + password + ", avater=" + avater
				+ ", mobile=" + mobile + ", createDate=" + createDate + ", lastLoginDate=" + lastLoginDate + ", status="
				+ status + "]";
	}

}
