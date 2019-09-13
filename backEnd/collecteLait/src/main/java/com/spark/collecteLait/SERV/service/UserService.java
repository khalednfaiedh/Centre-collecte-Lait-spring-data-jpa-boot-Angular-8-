package com.spark.collecteLait.SERV.service;

import java.util.List;

import com.spark.collecteLait.model.entity.User;

public interface UserService {
	
	
	public User getUserById(Long id);
	public List<User> getAllUsers();
	public User saveUser(User user);
	public User updateUser(Long id, User user);
	public void deleteUserById(Long id);

}
