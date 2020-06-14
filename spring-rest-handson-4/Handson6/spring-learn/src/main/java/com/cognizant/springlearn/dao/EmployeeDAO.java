package com.cognizant.springlearn.dao;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@Component
public class EmployeeDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDAO.class);
	private ArrayList<Employee> employeeList;
	private ClassPathXmlApplicationContext context;	
	
	public EmployeeDAO()
	{
		super();
//		LOGGER.info("Start");
//		LOGGER.info("in empoyeeDAO constructor");
		context = new ClassPathXmlApplicationContext("employee.xml");
		this.setEmployeeList((ArrayList<Employee>) context.getBean("employeeList", java.util.ArrayList.class));
		//LOGGER.debug("list-{}",this.getEmployeeList());
		//LOGGER.info("end contruct");
	}
	
	public ArrayList<Employee> getEmployeeList() {
		return employeeList;
	}

	public  void setEmployeeList(ArrayList<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	
	
	public ArrayList<Employee> getAllEmployees()
	{
		return employeeList;
	}
	
	
	
	public void updateEmployee(Employee employee)throws EmployeeNotFoundException
	{
		ArrayList<Employee> employeeList=getEmployeeList();
		boolean found=false;
		
		int index=0;		
		for(Employee e:employeeList)
		{
			if(e.getId()==employee.getId())
			{
				found=true;
				break;				
			}
			index++;
		}
		
		if(!found)
		{
			throw new EmployeeNotFoundException();
		}
		else
		{
			employeeList.get(index).setName(employee.getName());
			employeeList.get(index).setSalary(employee.getSalary());
			employeeList.get(index).setPermanent(employee.isPermanent());
			employeeList.get(index).setDateOfBirth(employee.getDateOfBirth());
		}
	}
	
	public void deleteEmployee(Employee employee)throws EmployeeNotFoundException
	{
		ArrayList<Employee> employeeList=getEmployeeList();
		boolean found=false;
		
		int index=0;		
		for(Employee e:employeeList)
		{
			if(e.getId()==employee.getId())
			{
				found=true;
				break;				
			}
			index++;
		}
		
		if(!found)
		{
			throw new EmployeeNotFoundException();
		}
		else
		{
			employeeList.remove(index);			
		}
	}

	
	

}
