package com.greatLearning.EmployeeManagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	// add mapping for "/" :: info or home page
	@GetMapping("/")
	public String showHomePage() {
		return "Welcome to the Employee Management System - Spring Security & Rest API";
	}

}