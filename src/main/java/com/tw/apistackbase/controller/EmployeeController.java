package com.tw.apistackbase.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tw.apistackbase.dao.EmployeeDao;
import com.tw.apistackbase.data.DB;
import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.serivce.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public ResponseEntity<List<Employee>> queryEmployees(@RequestParam(value="name",required=false) String name) {
		List<Employee> list = employeeService.getData();
		
		List<Employee> returnList = new ArrayList<>();
		if(name == null) {
			return ResponseEntity.ok(list);
		}
		for(Employee curEmployee : list) {
			if(curEmployee.getName().indexOf(name) != -1) {
				returnList.add(curEmployee);
			}
		}
		if(returnList.size() == 0) {
			return ResponseEntity.ok(returnList);
		}
		return ResponseEntity.ok(list);
		
	}

	private List<Employee> getData() {
		List<Employee> list = new ArrayList<>();
		Employee employee = new Employee(1, "skb", 20, "male");
		Employee employee1 = new Employee(2, "zhangsan", 20, "male");
		list.add(employee);
		list.add(employee1);
		return list;
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
	
	@PostMapping("/add")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		boolean flag = true;
		if(employee == null) {
			return ResponseEntity.ok("Ê§°Ü");
		}else {
			flag = employeeService.add(employee);
		}
		return ResponseEntity.ok(flag?"³É¹¦":"Ê§°Ü");
		
	}
	
	
}
