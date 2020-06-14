package com.cognizant.springlearn.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.springlearn.dao.EmployeeDAO;
import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@Service
public class EmployeeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	@Autowired
	private EmployeeDAO employeeDAO;
	
	
	public EmployeeService() {
		super();
//		LOGGER.info("Start");
//		LOGGER.info("in empoyeeService constructor");
	}
	
	
	
	
	@Transactional
	public ArrayList<Employee> getAllEmployees()
	{
		return employeeDAO.getAllEmployees();
	}
	
	

	@Transactional
	public void updateEmployee(Employee employee)throws EmployeeNotFoundException
	{
		employeeDAO.updateEmployee(employee);		
	}
	
	@Transactional
	public void deleteEmployee(Employee employee)throws EmployeeNotFoundException
	{
		employeeDAO.deleteEmployee(employee);		
	}
	
	
}
