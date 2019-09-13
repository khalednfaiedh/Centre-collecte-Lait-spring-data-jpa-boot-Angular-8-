package com.spark.collecteLait.Rest.Controller;

import java.lang.reflect.Type;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.spark.collecteLait.Rest.Dto.UserDto;
import com.spark.collecteLait.SERV.serviceImp.UserServiceImp;
import com.spark.collecteLait.model.entity.User;

@RestController
public class UserController {
	
	@Autowired 
	private UserServiceImp userService;
	
	@Autowired
	private   ModelMapper modelMapper;
	
 	
	@GetMapping("/test2")
	public String  test()
	{
		return "hello";
	}
	
	
     @GetMapping("/users/{id}")
     public ResponseEntity<UserDto> getUserById(@PathVariable long id)
     {
    	 User user=userService.getUserById(id);
    	 UserDto userDto=modelMapper.map(user,UserDto.class);
    	 return ResponseEntity.status(HttpStatus.OK).body(userDto);
     }
	
 
     @GetMapping("/users")
     public ResponseEntity<List<UserDto>> getAllsUser()
     {
    	 List<User> users = userService.getAllUsers();
    	 Type listType = new TypeToken<List<UserDto>>(){}.getType();
    	 List<UserDto>  UsersDto =modelMapper.map(users, listType);
    	return ResponseEntity.status(HttpStatus.OK).body(UsersDto); 
    	 
     }
     
 
     
     @PostMapping("/users")
     public ResponseEntity<@Valid UserDto> addUsers(@Valid @RequestBody  UserDto  userDto) {
    	 
    	 User user =modelMapper.map(userDto,  User.class);
    	 user=userService.saveUser(user);
    	 userDto= modelMapper.map( user,  UserDto.class);
    	 return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    	 
    	 
     }
     
     @PutMapping("/users/{id}")
     public ResponseEntity<@Valid UserDto> updateUser(@Valid @RequestBody  UserDto  userDto,@PathVariable long id) {
    	 
    	 User user =modelMapper.map(userDto,  User.class);
    	 user=userService.updateUser(id, user);
    	 userDto= modelMapper.map( user,  UserDto.class);
    	 return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    	 
    	 
     }
 	
     
 	@DeleteMapping("/users/{id}")
 	public  ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
 		userService.deleteUserById(id);
 		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
 	}
 	
      
   
	

}
