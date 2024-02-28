package com.greatlearning.EmployeeManagementApplicationSecurity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.EmployeeManagementApplicationSecurity.Entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
