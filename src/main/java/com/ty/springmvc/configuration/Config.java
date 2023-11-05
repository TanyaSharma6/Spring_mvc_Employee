package com.ty.springmvc.configuration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.ty.springmvc")
public class Config {

	@Bean(name="emf")
	@Scope("prototype")
	public EntityManagerFactory getEMF() {
		return new Persistence().createEntityManagerFactory("emp");
		
	}
	
}
