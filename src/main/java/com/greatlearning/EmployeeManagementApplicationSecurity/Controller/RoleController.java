package com.greatlearning.EmployeeManagementApplicationSecurity.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.EmployeeManagementApplicationSecurity.Entity.Role;
import com.greatlearning.EmployeeManagementApplicationSecurity.Service.RoleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	@GetMapping("/getAllRoles")
	public List<Role> getAllRoles() {
		log.info("RoleController getAllRoles()");
		return roleService.getAllRoles();
	}
	
	@PostMapping("/createNewRole")
	public String createNewRole(Role role) {
		log.info("RoleController createNewRole()");
		return roleService.createNewRole(role);
	}

}
