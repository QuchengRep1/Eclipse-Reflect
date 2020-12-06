package com.qucheng.reflectpj.entity;

import java.io.Serializable;

public class User implements Serializable {
	
	private String id;
	private String age;
	private String username;
	private String password;
	
	public User(String id, String age, String username, String password) {
		super();
		this.id = id;
		this.age = age;
		this.username = username;
		this.password = password;
	}
	
	public User() {}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
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
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	
	
}
