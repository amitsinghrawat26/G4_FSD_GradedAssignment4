package com.greatlearning.EmployeeManagementApplicationSecurity.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagementApplicationSecurity.Entity.Role;
import com.greatlearning.EmployeeManagementApplicationSecurity.Repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleReposotry;
	
	public List<Role> getAllRoles(){
		return roleReposotry.findAll();
	}
	
	public String createNewRole(Role role) {
		roleReposotry.save(role);
		roleReposotry.flush();
		return "Role sucessfully saved to DB";
		
	}
}
