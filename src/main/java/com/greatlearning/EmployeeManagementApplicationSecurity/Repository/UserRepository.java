package com.greatlearning.EmployeeManagementApplicationSecurity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.EmployeeManagementApplicationSecurity.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
