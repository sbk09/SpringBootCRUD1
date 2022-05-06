package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Employee;
import com.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	//How to mock a pay load that we get from request body
	//write test cases also for a controller
	//json.assert methods
	//lets see that we can jackson to handle json 
	//integration testing / eye-testing how it is done
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return service.getAllEmployee();
	}
	
	@PostMapping("/addemployee")
	public Employee addEmployee(@RequestBody Employee emp) {
		return service.saveEmployee(emp);
	}
	
	@PutMapping("/update")
	public Employee updateEmp(@RequestBody Employee emp) {
		return service.updateEmp(emp);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmpl(@PathVariable("id") int id) {
		return service.deleteEmp(id);
	}
	
<<<<<<< HEAD
	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable("id") int id) {
		return service.getEmpByID(id);
	}
	
	@PatchMapping("/salary/{id}/{salary}")
	public Employee updateSalary(@PathVariable("id") int id, @PathVariable("salary") int sal) {
		return service.updateSal(id, sal);
	}
	
=======
	@GetMapping("/employees/{id}")
	public Optional<Employee> getByID(@PathVariable("id") int id ) {
		return service.getEmpByID(id);
	}
	
>>>>>>> 9bd56ed8efdc53f0adcfb9c920657e15005e7547

}
