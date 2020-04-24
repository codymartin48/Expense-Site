package com.revature.dao;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.EmployeeAccount;
import com.revature.model.ReimbursementRequest;

public interface EmployeeAccountDao {
	public EmployeeAccount loginEmployee(String username, String password);
	public void submitReimbursementRequest(String amount, String requester, String description, InputStream receiptStream);
	public List<ReimbursementRequest> getPendingList();
	public ArrayList<ReimbursementRequest> getResolvedList();
	public ArrayList<ReimbursementRequest> getMyPendingList(String username);
	public ArrayList<ReimbursementRequest> getMyResolvedList(String username);
	public EmployeeAccount viewInfo(String username);
	public void editInfo(String firstName, String lastName, String username);
}
