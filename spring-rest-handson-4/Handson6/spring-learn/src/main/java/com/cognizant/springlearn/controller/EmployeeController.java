package com.cognizant.springlearn.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.EmployeeService;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@RestController
public class EmployeeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping(path="/employees")
	public ArrayList<Employee> getAllEmployees()
	{
		LOGGER.info("Start");
		ArrayList<Employee> employees=null;			
		
			employees=employeeService.getAllEmployees();		
			LOGGER.debug("Employees- {}", employees);				
	
		LOGGER.info("End");	
		return employees;
	}
	
	@PutMapping(path="/employees")
	public void updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException
	{
		LOGGER.info("Start");
		LOGGER.info("In updateEmployee()");
		employeeService.updateEmployee(employee);
		LOGGER.info("End");				
	}
	
	@DeleteMapping(path="/employees")
	public void deleteEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException
	{
		LOGGER.info("Start");
		LOGGER.info("In deleteEmployee()");
		employeeService.deleteEmployee(employee);
		LOGGER.info("End");				
	}
	
	

}
