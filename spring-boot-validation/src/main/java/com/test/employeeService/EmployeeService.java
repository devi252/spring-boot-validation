package com.test.employeeService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.employeeRepo.EmployeeRepo;
import com.test.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	public List<Employee> getEmployeeList(){
		return employeeRepo.findAll();
	}
	
	public Object createEmployee(Employee emp) {
		return employeeRepo.save(emp);
	}
	
	public String deleteEmployee(int id) {
		Optional<Employee> findById = employeeRepo.findById(id);
		
		if(findById.isPresent()) {
			employeeRepo.deleteById(id);
			return "record deleted with id : " +id;
		}
		else {
			return "no record found with id ; " +id;
		}
	}

	public Object updateEmployee(Employee emp) {
		Optional<Employee> findById = employeeRepo.findById(emp.getId());
		if(findById.isPresent()) {
			Employee saved = employeeRepo.save(emp);
			return saved;
		}else {
			return "No record found wit id : " +emp.getId();
		}
	}
	
}
