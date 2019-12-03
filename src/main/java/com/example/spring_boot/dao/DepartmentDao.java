package com.example.spring_boot.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.spring_boot.entities.Department;

@Repository
public class DepartmentDao {

	private static Map<Integer, Department> departments = null;

	
	public Collection<Department> getDepartments(){
		return departments.values();
	}
	
	public Department getDepartment(Integer id){
		return departments.get(id);
	}
	
}
