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
class AccountTestSet {

	EmployeeAccount employee;
	
	@BeforeAll
	public void setup() {
		employee = new EmployeeAccount();
	}
	
	@Test
	public void testSetUsername() {
		employee.setUsername("donnydorko");
		Assertions.assertEquals("donnydorko", employee.getUsername());
	}
	
	@Test
	public void testSetPassword() {
		employee.setPassword("dorkenstein33");
		Assertions.assertEquals("dorkenstein33", employee.getPassword());
	}
	
	@Test
	public void testSetFirstName() {
		employee.setFirstName("Donald");
		Assertions.assertEquals("Donald", employee.getFirstName());
	}
	
	@Test
	public void testSetLastName() {
		employee.setLastName("Dorkmann");
		Assertions.assertEquals("Dorkmann", employee.getLastName());
	}
	
	@Test
	public void testSetManager() {
		employee.setManager("Mr. Penni");
		Assertions.assertEquals("Mr. Penni", employee.getManager());
	}
	
	@Test
	public void testSetIsManager() {
		employee.setIsManager(false);
		Assertions.assertEquals(false, employee.getIsManager());
	}

}
