package com.qucheng.reflectpj.dao;

import java.util.List;

import com.qucheng.reflectpj.entity.User;

public interface IUserDao {
	
	User findUserById(int id);
	
	List<User> findAllUsers();
	
	User findUsersByUserName(); 
	
	void saveUser(User user);

}
