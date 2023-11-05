package com.ty.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springmvc.dto.Employee;


@Repository
public class EmployeeDao {

	@Autowired
	EntityManagerFactory entityManagerFactory;

	public Employee saveEmployee(Employee employee) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		
		return employee;
	}
	
	
	public Employee findEmployeeById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Employee employee= entityManager.find(Employee.class, id);
		
		return employee;
	}
	
	public List<Employee> getAllEmployee(){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		
		Query q= entityManager.createQuery("Select e from Employee e");
		
		List<Employee> employee= q.getResultList();
		
		return employee;	
			
	}
	
	public Employee updateEmployee(Employee employee) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.merge(employee);
		entityTransaction.commit();
		
		
		return employee;
	}
	
	public void deleteEmployee(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Employee  employee =entityManager.find(Employee.class,id);
		
		if(employee!=null) {
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
		}
		
		
	}
	
	public Employee getEmployeeByEmail(String email) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Query query = entityManager.createQuery("select e from Employee e where e.email=?1");
		
		Employee employee=(Employee)query.setParameter(1, email).getSingleResult();
		
		return employee;
	}
	
	public Employee editEmployeeById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		
		Employee employee=entityManager.find(Employee.class, id);
		
		return employee;
	}
}
