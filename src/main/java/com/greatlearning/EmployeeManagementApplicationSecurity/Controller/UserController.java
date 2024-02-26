package com.greatlearning.EmployeeManagementApplicationSecurity.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.EmployeeManagementApplicationSecurity.Entity.User;
import com.greatlearning.EmployeeManagementApplicationSecurity.Service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/ems/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/getUserDetails")
	public List<User> getUserDetails(){
		log.info("UserController createUser()");
		return userService.getUsers();
	}
	
	@PostMapping("/createUser")
	public String createUser(@RequestBody User user){
		log.info("UserController createUser()");
		return userService.createUser(user);
	}
	
}
