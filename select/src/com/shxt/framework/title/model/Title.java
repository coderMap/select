package com.shxt.framework.title.model;

import com.shxt.framework.student.model.Student;
import com.shxt.framework.user.model.User;

public class Title {
	private Integer title_id;
	private String title_name;
	private String title_desc;
	private Integer teacher_id;
	private Integer status;
	private Integer student_id;
	
	// 关联用户
	private User user;
	//关联学生
	private Student student;
	public Integer getTitle_id() {
		return title_id;
	}
	public void setTitle_id(Integer title_id) {
		this.title_id = title_id;
	}
	public String getTitle_name() {
		return title_name;
	}
	public void setTitle_name(String title_name) {
		this.title_name = title_name;
	}
	public String getTitle_desc() {
		return title_desc;
	}
	public void setTitle_desc(String title_desc) {
		this.title_desc = title_desc;
	}
	public Integer getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(Integer teacher_id) {
		this.teacher_id = teacher_id;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Title [title_id=" + title_id + ", title_name=" + title_name + ", title_desc=" + title_desc
				+ ", teacher_id=" + teacher_id + ", status=" + status + ", student_id=" + student_id + ", user=" + user
				+ ", student=" + student + "]";
	}
	
	
}
