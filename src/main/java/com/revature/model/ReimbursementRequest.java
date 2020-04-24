package com.revature.model;

import java.io.InputStream;

public class ReimbursementRequest {

	private String amount = "0.0";
	private String requester = "";
	private String description = "";
	private byte[] receipt;
	private int id;

	

	public ReimbursementRequest() {

	}

	public ReimbursementRequest(String amount, String requester, String description, byte[] receipt, int id) {
		this.amount = amount;
		this.requester = requester;
		this.description = description;
		this.receipt = receipt;
		this.id = id;
	}

	

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getRequester() {
		return requester;
	}

	public void setRequester(String requester) {
		this.requester = requester;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getReceipt() {
		return receipt;
	}

	public void setReceipt(byte[] receipt) {
		this.receipt = receipt;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
