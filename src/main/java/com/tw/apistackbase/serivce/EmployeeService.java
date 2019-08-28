package com.tw.apistackbase.serivce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tw.apistackbase.data.DB;
import com.tw.apistackbase.model.Employee;;


@Service
public class EmployeeService {
	@Autowired
	private DB db; 
	public boolean add(Employee employee) {
		return db.add(employee);
	}
	
	public List<Employee> getData() {
		return db.getAllData();
	}
	
	
}
