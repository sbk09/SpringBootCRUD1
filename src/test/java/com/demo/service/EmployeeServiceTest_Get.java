package com.demo.service;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import com.demo.entity.Employee;
import com.demo.repository.EmployeeRepository;

class EmployeeServiceTest_Get {
	
	EmployeeRepository repo=mock(EmployeeRepository.class);
	Employee emp=new Employee(1, "Ram", "Test", 500000);
	EmployeeService service=new EmployeeService(repo);
	

	@Test
	void test() {
		int id=1;
		when(repo.findById(id)).thenReturn(Optional.of(emp));
		
		System.out.println(emp);

		assertEquals(emp, service.getEmpByID(1));
	}

}
