package com.revature.tests;

import static org.junit.jupiter.api.Assertions.*;

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
class RequestTestSet {

	ReimbursementRequest request;
	byte[] byteArray;
	
	@BeforeAll
	public void setup() {
		byteArray = new byte[2];
		byteArray[0] = 0x11;
		byteArray[1] = 0x00;
		request = new ReimbursementRequest();
	}
	
	@Test
	void testSetAmount() {
		request.setAmount("34");
		
		Assertions.assertEquals("34", request.getAmount());
	}
	
	@Test
	void testSetRequester() {
		request.setRequester("onlinewewman");
		
		Assertions.assertEquals("onlinewewman", request.getRequester());
	}
	
	@Test
	void testSetDescription() {
		request.setDescription("I like 34");
		
		Assertions.assertEquals("I like 34", request.getDescription());
	}
	
	@Test
	void testSetByteArray() {
		request.setReceipt(byteArray);
		
		Assertions.assertEquals(byteArray, request.getReceipt());
	}
	
	@Test
	void testSet() {
		request.setId(10);
		
		Assertions.assertEquals(10, request.getId());
	}
	
	
}
