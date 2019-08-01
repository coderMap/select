package com.shxt.framework.log.model;

import java.util.Date;
import com.shxt.framework.user.model.User;
public class LoginLog {
	/**日志表ID*/
	private String id;
	/**用户ID*/
	private Integer user_id;
	/**登录时间 */
	private Date login_time;
	/**IP地址*/
	private String ip;
	/**与User建立关联用户*/
	private User user;

	public String getId() {
		return this.id;
	}
	public void setId( String id ) {
		this.id = id;
	}
	public Integer getUser_id() {
		return this.user_id;
	}
	public void setUser_id( Integer user_id ) {
		this.user_id = user_id;
	}
	public Date getLogin_time() {
		return this.login_time;
	}
	public void setLogin_time( Date login_time ) {
		this.login_time = login_time;
	}
	public String getIp() {
		return this.ip;
	}
	public void setIp( String ip ) {
		this.ip = ip;
	}
	public User getUser() {
		return this.user;
	}
	public void setUser( User user ) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "LoginLog [id=" + this.id + ", user_id=" + this.user_id + ", login_time=" + this.login_time + ", ip="
				+ this.ip + ", user=" + this.user + "]";
	}
}
