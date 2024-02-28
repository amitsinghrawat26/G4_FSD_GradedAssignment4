package com.greatlearning.EmployeeManagementApplicationSecurity.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.EmployeeManagementApplicationSecurity.Entity.Employee;
import com.greatlearning.EmployeeManagementApplicationSecurity.Service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/ems")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployee() {
		log.info("EmployeeController getAllEmployee()");
		return employeeService.findAll();
	}

	@PostMapping("/createEmployee")
	public String createEmployee(Employee employee) {
		log.info("EmployeeController showFormForAdd()");
		Employee newEmployee = employee;
		return employeeService.save(newEmployee);
	}

	@PostMapping("/updateEmployee")
	public String updateEmployee(Employee employee) {
		log.info("EmployeeController updateEmployee() : " + employee);
		Employee newEmployee;
		if (employee.getId() != 0) {
			newEmployee = employeeService.findById(employee.getId());
			newEmployee.setFirstName(employee.getFirstName());
			newEmployee.setLastName(employee.getLastName());
			newEmployee.setEmail(employee.getEmail());
		} else {
			newEmployee = new Employee(employee.getId(), employee.getFirstName(), employee.getLastName(),
					employee.getEmail());
		}
		return employeeService.save(newEmployee);
	}

	@GetMapping("/sortEmployeeByName")
	public List<Employee> sortEmployeeByName() {
		log.info("EmployeeController sortEmployeeByName()");
		List<Employee> theEmployees = employeeService.sortEmployeeByName();
		return theEmployees;
	}

	@DeleteMapping("/deleteEmployeeById")
	public String deleteEmployeeById(int id) {
		log.info("EmployeeController DeleteEmployeeById()");
		return employeeService.delete(id);
	}

	@GetMapping("/searchEmployeeByName")
	public List<Employee> searchEmployeeByName(String name) {
		log.info("EmployeeController searchEmployeeByName()");
		return employeeService.searchEmployee(name);
	}

	@RequestMapping("/403")
	public String accessDenied() {
		log.info("EmployeeController accessDenied()");
		return "msg" + "you don't have permission to this page!!!";
	}

}
