package com.revature.model;

public class EmployeeAccount {
	private String username = "";
	private String password = "";
	private String FirstName = "";
	private String LastName = "";
	private String manager = "";
	private boolean isManager = false;
	
	public EmployeeAccount(String username, String password, String firstName, String lastName, String manager, boolean isManager) {
		super();
		this.username = username;
		this.password = password;
		FirstName = firstName;
		LastName = lastName;
		this.manager = manager;
		this.isManager = isManager;
	}
	
	
	public EmployeeAccount(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		
	}
	
	public EmployeeAccount() {
		
	}


	//getters and setters
	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public boolean getIsManager() {
		return isManager;
	}

	public void setIsManager(boolean isManager) {
		this.isManager = isManager;
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}
}
