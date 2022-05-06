package com.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.entity.Employee;
import com.demo.repository.EmployeeRepository;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = EmployeeService.class)
class EmployeeServiceTest {

	/*
	 * @Rule public MockitoRule rule = MockitoJUnit.rule();
	 */
	private EmployeeRepository repo=mock(EmployeeRepository.class);

	private EmployeeService service=new EmployeeService(repo);;
	private Employee emp=new Employee(1, "Ram", "Development", 50000);;

	/*
	 * @Before public void setUp() { service=new EmployeeService(repo); emp = new
	 * Employee(1, "Ram", "Development", 50000); }
	 */

	/*
	 * repo = mock(EmployeeRepository.class);
	 * Mockito.when(repo.save(emp)).thenReturn(emp); service = new
	 * EmployeeService(repo); System.out.println(emp);
	 */ @Test
	void testSaveEmployee_Positive() {
		 when(repo.save(emp)).thenReturn(emp);

		assertEquals(emp, service.saveEmployee(emp));
	}

}
