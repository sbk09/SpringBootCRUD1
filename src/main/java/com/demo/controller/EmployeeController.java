package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/employees/{id}")
	public Optional<Employee> getByID(@PathVariable("id") int id ) {
		return service.getEmpByID(id);
	}
	

}
