package com.ty.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ty.springmvc.dao.EmployeeDao;
import com.ty.springmvc.dto.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao dao;
	
	public void saveEmployee(Employee employee) {
			dao.saveEmployee(employee);
			
	}
	
	public List<Employee> getAllEmployee(){
			return dao.getAllEmployee();
	}
	
	public Employee getEmployeeByEmail(Employee employee) {
		Employee loggedEmployee= dao.getEmployeeByEmail(employee.getEmail());
		
		if(loggedEmployee.getPassword().equals(employee.getPassword())) {
			return employee;
		}
		return null;
	}
	
	public void deleteEmployee(int id) {
		dao.deleteEmployee(id);
	}
	
	public Employee editEmployee(int id) {
		return dao.editEmployeeById(id);
	}
	
	public Employee updateEmployee(Employee employee) {
		return dao.updateEmployee(employee);
	}
	
	
}

