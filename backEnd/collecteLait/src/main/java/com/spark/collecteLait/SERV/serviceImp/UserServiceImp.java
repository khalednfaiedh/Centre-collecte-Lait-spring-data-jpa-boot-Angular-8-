package com.spark.collecteLait.SERV.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spark.collecteLait.Repository.UserRepository;
import com.spark.collecteLait.SERV.service.UserService;
import com.spark.collecteLait.model.entity.User;

@Service
public class UserServiceImp implements UserService {

@Autowired
private UserRepository userRepository;

	@Override
	public User getUserById(Long id) {
	 
		return  userRepository.findById(id).get();
	}

	@Override
	public List<User> getAllUsers() {
		 
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(Long id, User user) {
	  user.setId(id);
		return userRepository.save(user);
	}

	@Override
	public void deleteUserById(Long id) {
		
		userRepository.deleteById(id);
	  
	}

}
