package com.revature.model;

public class RequestWithManager extends ReimbursementRequest {
	String manager = "";
	String resolution = "";
	
	
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public RequestWithManager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequestWithManager(String amount, String requester, String description, byte[] receipt, int id, String manager, String resolution) {
		super(amount, requester, description, receipt, id);
		this.manager = manager;
		this.resolution = resolution;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	
	
}
