package com.dragonsnest.model;

public class Manager {
	int pid;
	String id;
	String name;
	String password;
	String phone;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	@Override
	public String toString() {
		return "Manager [pid=" + pid + ", id=" + id + ", name=" + name
				+ ", password=" + password + ", phone=" + phone + "]";
	}
}
