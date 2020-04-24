package com.revature.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.revature.model.EmployeeAccount;

@RunWith(JUnitPlatform.class)
@TestInstance(Lifecycle.PER_CLASS)
class AccountTestGet {
	
	EmployeeAccount employee;
	
	@BeforeAll
	public void setup() {
		 employee = new EmployeeAccount("Admin", "2secure4you!", "Michael", "Winslow", "mrmeanier", true);
	}
	
	@Test
	public void testGetUsername(){
		Assertions.assertEquals("Admin", employee.getUsername());
	}
	
	@Test
	public void testGetPassword(){
		Assertions.assertEquals("2secure4you!", employee.getPassword());
	}
	
	@Test
	public void testGetFirstName(){
		Assertions.assertEquals("Michael", employee.getFirstName());
	}
	
	@Test
	public void testGetLastName(){
		Assertions.assertEquals("Winslow", employee.getLastName());
	}
	
	@Test
	public void testGetManager(){
		Assertions.assertEquals("mrmeanier", employee.getManager());
	}
	
	@Test
	public void testGetIsManager(){
		Assertions.assertEquals(true, employee.getIsManager());
	}
	

}
