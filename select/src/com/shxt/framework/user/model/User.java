package com.shxt.framework.user.model;


public class User {
	// �����������ݿ�������Զ�Ӧ
	/** �û�id */
	private Integer user_id;
	/** �˺� */
	private String account;
	/** ���� */
	private String password;
	/** �û��� */
	private String user_name;
	/** ״̬ */
	private Integer status;
	/** Ȩ�� */
	private String role_name;
	/** �༶id */
	private String class_id;
	/** ��Ŀid */
	private String title_id;

	private String birthday;
	private String address;
	private String phone;
	private String sex;
	private String qq;
	// ����༶
	//private Classes classes;
	// ������Ŀ
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
