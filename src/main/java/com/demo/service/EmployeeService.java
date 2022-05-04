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
	
	public String deleteEmp(int id) {
		repo.deleteById(id);
		return "Employee deleted With ID:"+id;
	}
	
	public Employee updateEmp(Employee e1) {
		Employee existingEmp=repo.findById(e1.getEmp_id()).orElse(null);
		existingEmp.setEmp_name(e1.getEmp_name());
		existingEmp.setEmp_dept(e1.getEmp_dept());
		existingEmp.setEmp_salary(e1.getEmp_salary());
		existingEmp.setEmp_id(e1.getEmp_id());
		return repo.save(existingEmp);
	}
}
