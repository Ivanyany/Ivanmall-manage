package com.ivan.mall.pojo;

/**
 * 用户信息实体类
 * @author Ivan
 *
 */

public class User {
	private Integer id;//用户id主键
	private String username;//用户名
	private String password;//用户密码
	private String phone;//用户电话
	private String email;//用户邮箱
	private String created;//用户创建时间
	private String updated;//用户更新时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", phone=" + phone + ", email="
				+ email + ", created=" + created + ", updated=" + updated + "]";
	}
}
