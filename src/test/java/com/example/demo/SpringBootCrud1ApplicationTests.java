package com.example.demo;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.demo.entity.Employee;
import com.demo.repository.EmployeeRepository;
import com.demo.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootCrud1ApplicationTests {

	@Rule
	public MockitoRule rule = MockitoJUnit.rule();
	@Autowired
	private EmployeeService service;
	@MockBean
	private EmployeeRepository repo;

	@Test
	public void getEmployeeTest() {
		when(repo.findAll()).thenReturn(
				Stream.of(new Employee(1, "Rohit", "Batting", 500000), new Employee(2, "Virat", "Batting", 1000000))
						.collect(Collectors.toList()));

		assertEquals(2, service.getAllEmployee().size());
	}

	@Test
	public void testDeleteEmp() {
		int x = 1;
		doNothing().when(repo).deleteById(x);
		assertEquals("Employee deleted With ID:" + x, service.deleteEmp(x));
	}

	@Disabled@Test
	public void testUpdateEmployee() {
		Employee e1 = new Employee(1, "Sachin", "BAtting", 200000);
		Employee temp = e1;
		when(repo.getById(1)).thenReturn(e1);
		when(repo.save(e1)).thenReturn(e1);
		assertEquals(e1, service.updateEmp(e1));
	}

}
