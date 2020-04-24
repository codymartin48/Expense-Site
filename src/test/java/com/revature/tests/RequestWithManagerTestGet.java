package com.revature.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.revature.model.RequestWithManager;

@RunWith(JUnitPlatform.class)
@TestInstance(Lifecycle.PER_CLASS)
class RequestWithManagerTestGet {

	RequestWithManager request;
	byte[] byteArray;
	
	@BeforeAll
	public void setup() {
		byteArray = new byte[2];
		byteArray[0] = 0x11;
		byteArray[1] = 0x00;
		request = new RequestWithManager("50", "Dave Dave", "I need 50 bucks", byteArray, 5, "billywilly", "Denied");
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
	void testGetId() {
		Assertions.assertEquals(5, request.getId());
	}

	@Test
	void testGetManager() {
		Assertions.assertEquals("billywilly", request.getManager());
	}
	
	@Test
	void testGetResolution() {
		Assertions.assertEquals("Denied", request.getResolution());
	}
}
