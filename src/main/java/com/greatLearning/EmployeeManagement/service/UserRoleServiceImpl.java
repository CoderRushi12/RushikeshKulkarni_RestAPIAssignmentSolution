package com.greatLearning.EmployeeManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatLearning.EmployeeManagement.entity.Role;
import com.greatLearning.EmployeeManagement.entity.User;
import com.greatLearning.EmployeeManagement.repository.RoleRepository;
import com.greatLearning.EmployeeManagement.repository.UserRepository;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	
	
	@Override
	public String addUser(User user) {
		
		userRepository.saveAndFlush(user);
		return "User added successfully";
	}
	
	
	@Override
	public String addRole(Role role) {

		roleRepository.saveAndFlush(role);
		return "Role added successfully";
	}
	
	

}