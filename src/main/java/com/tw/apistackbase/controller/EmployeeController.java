package com.tw.apistackbase.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tw.apistackbase.model.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@GetMapping
	public ResponseEntity<List<Employee>> queryEmployees() {
		List<Employee> list = new ArrayList<>();
		Employee employee = new Employee(1, "skb", 20, "male");
		list.add(employee);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value="/{employeeId}")
	public ResponseEntity<Employee> queryEmployeesById(@PathVariable() int employeeId) {
		List<Employee> list = new ArrayList<>();
		Employee employee = new Employee(1, "skb", 20, "male");
		list.add(employee);
		for(int index = 0;index < list.size(); index++) {
			Employee currEmployee =  list.get(index);
			if(currEmployee.getId() == employeeId) {
				return ResponseEntity.ok(currEmployee);
			}
		}
		return null;
		
	}
	
	
}
