package com.revature.dao;

import java.util.ArrayList;

import com.revature.model.EmployeeAccount;
import com.revature.model.ReimbursementRequest;
import com.revature.model.RequestWithManager;

public interface ManagerAccountDao {
	public ArrayList<ReimbursementRequest> getPendingRequestsByManager(String manager);
	public ArrayList<EmployeeAccount> getEmployees();
	public ArrayList<ReimbursementRequest> getMyEmployeeRequests(String username);
	public boolean isMyEmployee (String employeeUsername, String managerUsername);
	public ArrayList<RequestWithManager> getallResolvedRequests();
	public void resolveRequest(int id, String resolution);
	
}
