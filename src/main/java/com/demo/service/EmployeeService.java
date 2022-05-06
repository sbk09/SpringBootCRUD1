package com.demo.service;


import java.util.List;
//<<<<<<< HEAD
import java.util.stream.Collectors;
import java.util.stream.Stream;
//=======
import java.util.Optional;
//>>>>>>> 9bd56ed8efdc53f0adcfb9c920657e15005e7547

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Employee;
import com.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	
	public EmployeeService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeService(EmployeeRepository repo) {
		super();
		this.repo = repo;
	}

	public Employee saveEmployee( Employee emp) {
		return repo.save(emp);
	}
	
	public Employee getEmpByID(int id) {
		return repo.findById(id).get();
	}
	
	public List<Employee> getAllEmployee(){
		Stream.of(repo.findAll()).collect(Collectors.toList()).forEach(x -> System.out.println(x));
		return repo.findAll();
	}
	
	public String deleteEmp(int id) {
		repo.deleteById(id);
		return "Employee deleted With ID:"+id;
	}
	/*
	 * public Optional<Employee> getEmpByID(int id) { return repo.findById(id); }
	 */
	
	public Employee updateEmp(Employee e1) {
		Employee existingEmp=repo.findById(e1.getEmp_id()).orElse(null);
		existingEmp.setEmp_name(e1.getEmp_name());
		existingEmp.setEmp_dept(e1.getEmp_dept());
		existingEmp.setEmp_salary(e1.getEmp_salary());
		existingEmp.setEmp_id(e1.getEmp_id());
		return repo.save(existingEmp);
	}
	
	public Employee updateSal(int id, int salary) {
		Employee existing=repo.findById(id).get();
		existing.setEmp_salary(salary);
		return repo.save(existing);
	}
}
