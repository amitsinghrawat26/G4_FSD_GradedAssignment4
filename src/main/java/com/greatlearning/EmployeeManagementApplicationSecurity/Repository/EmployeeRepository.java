package com.greatlearning.EmployeeManagementApplicationSecurity.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.greatlearning.EmployeeManagementApplicationSecurity.Entity.Employee;
import com.greatlearning.EmployeeManagementApplicationSecurity.Entity.User;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	List<Employee> findByFirstNameContainsAllIgnoreCase(String firstName);
}
