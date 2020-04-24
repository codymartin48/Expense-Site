package com.revature.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.revature.model.ReimbursementRequest;

@RunWith(JUnitPlatform.class)
@TestInstance(Lifecycle.PER_CLASS)
class RequestTestGet {

	ReimbursementRequest request;
	byte[] byteArray;
	
	@BeforeAll
	public void setup() {
		byteArray = new byte[2];
		byteArray[0] = 0x11;
		byteArray[1] = 0x00;
		request = new ReimbursementRequest("50", "Dave Dave", "I need 50 bucks", byteArray, 5);
	}
	
	@Test
	void testGetAmount() {
		Assertions.assertEquals("50", request.getAmount());
	}
	
	@Test
	void testGetRequester() {
		Assertions.assertEquals("Dave Dave", request.getRequester());
	}
	
	@Test
	void testGetDescription() {
		Assertions.assertEquals("I need 50 bucks", request.getDescription());
	}
	
	@Test
	void testGetByteArray() {
		Assertions.assertEquals(byteArray, request.getReceipt());
	}
	
	@Test
	void testGet() {
		Assertions.assertEquals(5, request.getId());
	}

}
