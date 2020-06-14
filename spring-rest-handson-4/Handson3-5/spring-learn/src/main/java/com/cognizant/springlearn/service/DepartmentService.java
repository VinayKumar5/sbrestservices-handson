package com.cognizant.springlearn.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.springlearn.dao.DepartmentDAO;
import com.cognizant.springlearn.model.Department;

@Service
public class DepartmentService {
	
	
	@Autowired
	private DepartmentDAO departmentDAO;
	
	@Transactional
	public ArrayList<Department> getAllDepartments()
	{
		return departmentDAO.getAllDepartments();
	}

}
