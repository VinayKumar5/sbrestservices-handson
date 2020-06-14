package com.cognizant.springlearn.dao;

import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.springlearn.model.Department;

@Component
public class DepartmentDAO {

	private static ArrayList<Department> departmentList;

	public DepartmentDAO() {
		super();
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		this.setDepartmentList((ArrayList<Department>) context.getBean("departmentList", java.util.ArrayList.class));
	}

	public static ArrayList<Department> getDepartmentList() {
		return departmentList;
	}

	public static void setDepartmentList(ArrayList<Department> departmentList) {
		DepartmentDAO.departmentList = departmentList;
	}
	
	public ArrayList<Department> getAllDepartments()
	{
		return departmentList;
	}

}
