package com.revature.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.revature.dao.EmployeeAccountImpl;
import com.revature.model.EmployeeAccount;
import com.revature.model.ReimbursementRequest;

@RunWith(JUnitPlatform.class)
@TestInstance(Lifecycle.PER_CLASS)
class EmployeeAccountImplTest {

	@Mock
	EmployeeAccountImpl dao;

	@Mock
	List<ReimbursementRequest> requests = Arrays.asList(
			new ReimbursementRequest("50", "Dave Dave", "I need 50 bucks", null, 5),
			new ReimbursementRequest("100", "Naruto", "Dave sucks", null, 6));;

	@BeforeAll
	public void setup() {

		dao = new EmployeeAccountImpl();

		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testLogin() {
		Mockito.when(dao.loginEmployee("whiteboyrick", "heylaserlips")).thenReturn(
				new EmployeeAccount("whiteboyrick", "heylaserlips", "Richard", "Martin", "billywilly", false));

		Assertions.assertEquals("billywilly", dao.loginEmployee("whiteboyrick", "heylaserlips").getManager());
	}

}
