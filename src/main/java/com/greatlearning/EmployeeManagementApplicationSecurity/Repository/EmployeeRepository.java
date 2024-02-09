package com.greatlearning.EmployeeManagementApplicationSecurity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.greatlearning.EmployeeManagementApplicationSecurity.Entity.Employee;
import com.greatlearning.EmployeeManagementApplicationSecurity.Entity.User;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query("select u from User u where u.username = ?1")
	public User getUserByUsername(String user);
}
