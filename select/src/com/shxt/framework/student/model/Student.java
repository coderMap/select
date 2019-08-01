package com.shxt.framework.student.model;

import com.shxt.framework.title.model.Title;
import com.shxt.framework.user.model.User;

public class Student {
		private Integer student_id;
		private String account;
		private String student_name;
		private String password;
		private Integer status;
		private String role_name;
		private String class_name;
		private String phone;
		private String sex;
		
		//关联题目
		private Title title;
		//关联老师
		private User user;
		public Integer getStudent_id() {
			return student_id;
		}
		public void setStudent_id(Integer student_id) {
			this.student_id = student_id;
		}
		public String getAccount() {
			return account;
		}
		public void setAccount(String account) {
			this.account = account;
		}
		public String getStudent_name() {
			return student_name;
		}
		public void setStudent_name(String student_name) {
			this.student_name = student_name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
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
		public String getClass_name() {
			return class_name;
		}
		public void setClass_name(String class_name) {
			this.class_name = class_name;
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
		public Title getTitle() {
			return title;
		}
		public void setTitle(Title title) {
			this.title = title;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		@Override
		public String toString() {
			return "Student [student_id=" + student_id + ", account=" + account + ", student_name=" + student_name
					+ ", password=" + password + ", status=" + status + ", role_name=" + role_name + ", class_name="
					+ class_name + ", phone=" + phone + ", sex=" + sex + ", title=" + title + ", user=" + user + "]";
		}
		
}
