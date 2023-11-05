package com.ty.springmvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.springmvc.dto.Employee;
import com.ty.springmvc.service.EmployeeService;

@Controller
public class ConfigController {
	@Autowired
	EmployeeService service;

	@RequestMapping("login")
	public ModelAndView login() {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("employee",new Employee());		
		modelAndView.setViewName("login.jsp");
		return modelAndView;
			
	}
	
	@RequestMapping("signup")
	public ModelAndView signup(Employee employee) {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("signup.jsp");
		
		return modelAndView;
			
	}
	
	@RequestMapping("saveemployee")
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("signupsuccess.jsp");
		modelAndView.addObject("employee",new Employee());		
		service.saveEmployee(employee);
		
		return modelAndView;
			
	}
	
	@RequestMapping("view")
	public ModelAndView view(@ModelAttribute Employee employee) {
		
		Employee loggedEmployee = service.getEmployeeByEmail(employee);
		ModelAndView modelAndView = new ModelAndView();
		
		if(loggedEmployee!=null) {
			
			modelAndView.setViewName("view.jsp");
			modelAndView.addObject("ename",loggedEmployee.getName());
			modelAndView.addObject("elist",service.getAllEmployee());	
		}else {
			modelAndView.setViewName("login.jsp");
			
		}

		return modelAndView;		
		
	}
	
	
	@RequestMapping("viewlist")
	public ModelAndView viewList(Employee employee) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view.jsp");
		modelAndView.addObject("elist",service.getAllEmployee());
		
		return modelAndView;
	}
	
	
	
	@RequestMapping("deleteemployee")
	public void deleteemployee(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id= Integer.parseInt(req.getParameter("id"));
		
		service.deleteEmployee(id);
		RequestDispatcher dispatcher = req.getRequestDispatcher("viewlist");
		dispatcher.forward(req, res);
		
	}
	
	@RequestMapping("edit")
	public ModelAndView editEmployee(@RequestParam int id ) {
		ModelAndView modelAndView = new ModelAndView();
		Employee employee = service.editEmployee(id);
		modelAndView.setViewName("edit.jsp");
		modelAndView.addObject("employee",employee);
		
		return modelAndView;
	}
	
	
	@RequestMapping("editemployee")
	public void updatetable(@ModelAttribute Employee employee,HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		service.updateEmployee(employee);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("viewlist");
		dispatcher.forward(req, res);
		
	}
	
	
	
}
