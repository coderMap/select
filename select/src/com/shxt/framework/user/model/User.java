package com.shxt.framework.user.model;


public class User {
	// 属性名和数据库表中属性对应
	/** 用户id */
	private Integer user_id;
	/** 账号 */
	private String account;
	/** 密码 */
	private String password;
	/** 用户名 */
	private String user_name;
	/** 状态 */
	private Integer status;
	/** 权限 */
	private String role_name;
	/** 班级id */
	private String class_id;
	/** 题目id */
	private String title_id;

	private String birthday;
	private String address;
	private String phone;
	private String sex;
	private String qq;
	// 管理班级
	//private Classes classes;
	// 关联题目
	//private Title title;
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getClass_id() {
		return class_id;
	}
	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}
	public String getTitle_id() {
		return title_id;
	}
	public void setTitle_id(String title_id) {
		this.title_id = title_id;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", account=" + account + ", password=" + password + ", user_name="
				+ user_name + ", status=" + status + ", role_name=" + role_name + ", class_id=" + class_id
				+ ", title_id=" + title_id + ", birthday=" + birthday + ", address=" + address + ", phone=" + phone
				+ ", sex=" + sex + ", qq=" + qq + "]";
	}
	
}
