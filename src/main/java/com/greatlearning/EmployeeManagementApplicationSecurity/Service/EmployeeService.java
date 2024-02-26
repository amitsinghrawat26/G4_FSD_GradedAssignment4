package com.greatlearning.EmployeeManagementApplicationSecurity.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagementApplicationSecurity.Entity.Employee;
import com.greatlearning.EmployeeManagementApplicationSecurity.Repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class EmployeeService {
	
	@Autowired
	public EmployeeRepository employeeRepository;
	
	public List<Employee> findAll(){
		log.info("EmployeeService findAll()"+employeeRepository.findAll());
		return employeeRepository.findAll();
	}
	
	public Employee findById(Integer id) {
		log.info("EmployeeService findById(Integer id)");
		return employeeRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Employee ID"));
	}
	
	public String update(Integer id, Employee newEmployee) {
		log.info("EmployeeService update(Integer id)");
		Employee oldEmployee = employeeRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Employee ID"));
		oldEmployee.setFirstName(newEmployee.getFirstName());
		oldEmployee.setLastName(newEmployee.getLastName());
		oldEmployee.setEmail(newEmployee.getEmail());
		return "Employee details updated";

	}
	
	public String save(Employee employee) {
		log.info("EmployeeService save(Employee employee)");
		employeeRepository.save(employee);
		employeeRepository.flush();
		return "Employee details saved";
	}
	
	public String delete(Integer id) {
		log.info("EmployeeService delete(Integer Int)");
		employeeRepository.deleteById(id);
		return "Employee deleted sucessfully";
	}
	
	public List<Employee> searchEmployee(String firstName){
		log.info("EmployeeService searchEmployee(String name)");
		if(firstName.trim().isEmpty()) {
			log.info("No Employee found");
		}
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		
		ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("firstName", ExampleMatcher.GenericPropertyMatchers.contains())
				.withIgnorePaths("lastName","email","id");
		Example<Employee> example = Example.of(employee, exampleMatcher);
		
		return employeeRepository.findAll(example);
	}

	public List<Employee> sortEmployeeByName() {
		log.info("EmployeeService sortEmployee(String firstName)");
		return employeeRepository.findAll(Sort.by( Direction.DESC, "firstName"));
	}

}
