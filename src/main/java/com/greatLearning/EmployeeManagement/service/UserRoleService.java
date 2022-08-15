package com.greatLearning.EmployeeManagement.service;

import com.greatLearning.EmployeeManagement.entity.Role;
import com.greatLearning.EmployeeManagement.entity.User;

public interface UserRoleService {

	String addUser(User user);

	String addRole(Role role);

}
