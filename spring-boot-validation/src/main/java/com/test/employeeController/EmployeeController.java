package com.test.employeeController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.test.employeeService.EmployeeService;
import com.test.model.Employee;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = "/get-list")
	public List<Employee> getEmployeeList() {
		return employeeService.getEmployeeList();
	}

	@GetMapping("test")
	public String test() {
		int a = 16/0;
		
		return "application is working...";
	}

	@PostMapping(value = "/save")
	public Object createEmployee(@Valid @RequestBody Employee emp) {
		return employeeService.createEmployee(emp);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return employeeService.deleteEmployee(id);
	}
	
	@PutMapping("/update")
	public Object updateEmployee(@RequestBody Employee emp) {
		return employeeService.updateEmployee(emp);
	}
	
	

}
