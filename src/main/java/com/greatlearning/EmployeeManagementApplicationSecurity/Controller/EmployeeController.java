package com.greatlearning.EmployeeManagementApplicationSecurity.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("employees/employeeList")
	public String findAllEmployee(Model model){
		log.info("EmployeeController findAllEmployee()");
		List<Employee> employees = employeeService.findAll();
		model.addAttribute("Employee", employees);
		return "List-employee";
	}

	@GetMapping("/employee/showFormForAdd")
	public String showFormForAdd(Model model) {
		log.info("EmployeeController showFormForAdd()");
		Employee newEmployee = new Employee();
		model.addAttribute("Employee", newEmployee);
		employeeService.save(newEmployee);
		return "Employee-form";
	}

	@PostMapping("/employee/save")
	public String save(@RequestParam("id") int id,@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,@RequestParam("email") String email) {
		log.info("EmployeeController save()");
		Employee newEmployee;
		if(id!=0) {
			newEmployee = employeeService.findById(id);
			newEmployee.setFirstName(firstName);
			newEmployee.setLastName(lastName);
			newEmployee.setEmail(email);
		}
		else {
			newEmployee = new Employee(id,firstName,lastName,email);
		}
		employeeService.save(newEmployee);
		return "redirect:/employees/employeeList";
	}

	@GetMapping("/employee/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id,Model model){
		log.info("EmployeeController showFormForUpdate() id"+id);

		Employee updatedEmployee = employeeService.findById(id);
		model.addAttribute("Employee", updatedEmployee);
		return "Employee-form";
	}
	
	@GetMapping("/employee/delete")
	public String DeleteEmployeeById(@RequestParam("id") int id)
	{
		log.info("EmployeeController DeleteEmployeeById()");
		employeeService.delete(id);
		return "redirect:/employees/employeeList";
	}

	@RequestMapping("/403")
	public ModelAndView accessDenied(Principal user) {
		log.info("EmployeeController accessDenied()");
		ModelAndView model = new ModelAndView();

		if(user != null) {
			model.addObject("msg","Hi "+user.getName()+", you don't have permission to this page!!!");
		}
		else {
			model.addObject("msg", "you don't have permission to this page!!!");
		}

		return model;
	}

}