package com.greatLearning.EmployeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatLearning.EmployeeManagement.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
