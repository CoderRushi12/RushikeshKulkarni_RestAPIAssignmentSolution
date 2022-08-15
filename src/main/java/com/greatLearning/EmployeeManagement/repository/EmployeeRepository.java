package com.greatLearning.EmployeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatLearning.EmployeeManagement.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
