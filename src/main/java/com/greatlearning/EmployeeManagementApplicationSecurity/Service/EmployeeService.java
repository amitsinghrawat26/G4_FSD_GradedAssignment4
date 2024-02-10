package com.greatlearning.EmployeeManagementApplicationSecurity.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public void update(Integer id, Employee newEmployee) {
		log.info("EmployeeService update(Integer id)");
		Employee oldEmployee = employeeRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Employee ID"));
		oldEmployee.setFirstName(newEmployee.getFirstName());
		oldEmployee.setLastName(newEmployee.getLastName());
		oldEmployee.setEmail(newEmployee.getEmail());
	}
	
	public void save(Employee employee) {
		log.info("EmployeeService save(Employee employee)");
		employeeRepository.save(employee);
	}
	
	public void delete(Integer id) {
		log.info("EmployeeService delete(Integer Int)");
		employeeRepository.deleteById(id);
	}
	
	public List<Employee> searchEmployee(String firstName){
		log.info("EmployeeService searchEmployee(String name)");
		return employeeRepository.findByFirstNameContainsAllIgnoreCase(firstName);
	}

}
