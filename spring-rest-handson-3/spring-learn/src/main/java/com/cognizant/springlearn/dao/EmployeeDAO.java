package com.cognizant.springlearn.dao;

import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.springlearn.model.Employee;

@Component
public class EmployeeDAO {
	
	private static ArrayList<Employee> employeeList;
	
	@SuppressWarnings("unchecked")
	public EmployeeDAO()
	{
		super();
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		this.setEmployeeList((ArrayList<Employee>) context.getBean("employeeList", java.util.ArrayList.class));
	}

	public static ArrayList<Employee> getEmployeeList() {
		return employeeList;
	}

	public static void setEmployeeList(ArrayList<Employee> employeeList) {
		EmployeeDAO.employeeList = employeeList;
	}
	
	
	public ArrayList<Employee> getAllEmployees()
	{
		return employeeList;
	}
	

}
