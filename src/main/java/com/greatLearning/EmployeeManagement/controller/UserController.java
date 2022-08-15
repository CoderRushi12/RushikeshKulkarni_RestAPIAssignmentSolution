package com.greatLearning.EmployeeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatLearning.EmployeeManagement.entity.User;
import com.greatLearning.EmployeeManagement.service.UserRoleService;


@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserRoleService userService;
	
	// add POST mapping for "/users/add" :: add new user data for authentication
	@PostMapping("/add")
	public String addUser(@RequestBody User user) {
		
		return userService.addUser(user);
	}

}