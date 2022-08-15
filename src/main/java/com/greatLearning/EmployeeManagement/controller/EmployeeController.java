package com.greatLearning.EmployeeManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatLearning.EmployeeManagement.entity.Employee;
import com.greatLearning.EmployeeManagement.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired 
	EmployeeService employeeService;

	// add GET mapping for "/employees/list" :: fetch all employees
	@GetMapping("/list")
	public List<Employee> fetchAllEmployees() {

		return employeeService.fetchAllEmployees();
	}

	// add GET mapping for "/employees/{id}" :: fetch employee based on id
	@GetMapping("/{id}")
	public Employee fetchEmployeeById(@PathVariable("id") Long id) {

		if (employeeService.fetchEmployeeById(id).isPresent()) {
			return employeeService.fetchEmployeeById(id).get();
		} else {
			return null;
		}
	}

	// add POST mapping for "/employees/add" :: save an employee record
	@PostMapping("/add")
	public String saveNewEmployee(@RequestBody Employee employee) {

		return employeeService.saveSingleEmployee(employee);
	}

	// add POST mapping for "/employees/addAll" :: save multiple employee records
	@PostMapping("/addAll")
	public String saveNewEmployee(@RequestBody List<Employee> employees) {

		return employeeService.saveAllEmployees(employees);
	}

	// add PUT mapping for "/employees/update/{id}" :: update an employee record
	// based on id
	@PutMapping("/update/{id}")
	public Employee updateEmployee(@PathVariable("id") Employee employee) {

		return employeeService.updateEmployeeById(employee);
	}

	// add DELETE mapping for "/employees/delete/{id}" :: delete an employee record
	// based on id
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable("id") Long id) {

		if (employeeService.fetchEmployeeById(id).isPresent()) {
			return employeeService.deleteEmployeeById(id);
		} else {
			return "No records found with employee id - " + id;
		}
	}

	// add GET mapping for "/employees/search/{firstName}" :: search employee
	// records based on firstName
	@GetMapping("/search/{firstName}")
	public List<Employee> searchEmployeeByFirstName(@PathVariable("firstName") String firstName) {

		return employeeService.fetchEmployeeSortedByIdWithThisFirstName(firstName);
	}

	// add GET mapping for "/employees/sort" :: sort all employee records using
	// firstName based on ASC or DESC direction
	@GetMapping("/sort")
	public List<Employee> sortEmployeeByFirstName(@RequestParam("direction") Direction direction) {

		return employeeService.fetchEmployeeCustomSortedByFirstName(direction);
	}

}