package com.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Employee;
import com.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	public Employee saveEmployee( Employee emp) {
		return repo.save(emp);
	}
	
	public List<Employee> getAllEmployee(){
		return repo.findAll();
	}

}
