package com.greatLearning.EmployeeManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.greatLearning.EmployeeManagement.entity.Employee;
import com.greatLearning.EmployeeManagement.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public String saveSingleEmployee(Employee employee) {

		employeeRepository.saveAndFlush(employee);
		return "Employee saved successfully";
	}

	@Override
	public String saveAllEmployees(List<Employee> employees) {

		employeeRepository.saveAll(employees);
		employeeRepository.flush();
		return "All Employees saved successfully";
	}

	@Override
	public List<Employee> fetchAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> fetchEmployeeById(Long id) {
		return employeeRepository.findById(id);
	}

	@Override
	public Employee updateEmployeeById(Employee employee) {

		if (employeeRepository.findById(employee.getId()).isPresent()) {

			Employee theEmployee = employeeRepository.findById(employee.getId()).get();

			theEmployee.setId(employee.getId());
			theEmployee.setFirstName(employee.getFirstName());
			theEmployee.setLastName(employee.getLastName());
			theEmployee.setEmail(employee.getEmail());

			employeeRepository.saveAndFlush(theEmployee);

			return theEmployee;
		} else {
			return null;
		}
	}

	@Override
	public String deleteEmployeeById(Long id) {

		employeeRepository.deleteById(id);
		return "Deleted employee id - " + id;
	}

	@Override
	public List<Employee> fetchEmployeeSortedByIdWithThisFirstName(String firstName) {

		Employee employeeWithFirstName = new Employee();
		employeeWithFirstName.setFirstName(firstName);

		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("firstName", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "lastName", "email");

		Example<Employee> example = Example.of(employeeWithFirstName, exampleMatcher);

		return employeeRepository.findAll(example, Sort.by("id"));
	}

	@Override
	public List<Employee> fetchEmployeeCustomSortedByFirstName(Direction direction) {
		return employeeRepository.findAll(Sort.by(direction, "firstName"));
	}

}
