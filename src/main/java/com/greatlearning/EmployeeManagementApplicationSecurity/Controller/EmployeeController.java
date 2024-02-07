package com.greatlearning.EmployeeManagementApplicationSecurity.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.EmployeeManagementApplicationSecurity.Entity.Employee;
import com.greatlearning.EmployeeManagementApplicationSecurity.Service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> findAllEmployee(){
		log.info("EmployeeController findAllEmployee()");
		return employeeService.findAll();
	}
	
	@PostMapping("/saveEmployee")
	public void saveEmployee(@RequestParam("id") int id,@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {
		
		Employee newEmployee = new Employee();
		newEmployee.setId(id);
		newEmployee.setFirstName(firstName);
		newEmployee.setLastName(lastName);
		newEmployee.setEmail(email);
		log.info("EmployeeController findAllEmployee()");
		employeeService.save(newEmployee);
	}
	
	@DeleteMapping("/deleteEmployeeById")
	public void DeleteEmployeeById(Integer id)
	{
		log.info("EmployeeController findAllEmployee()");
		employeeService.delete(id);
	}

}
