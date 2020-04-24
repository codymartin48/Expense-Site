package com.revature.utilities;

import java.util.ArrayList;

import com.revature.dao.ManagerAccountImpl;
import com.revature.model.EmployeeAccount;
import com.revature.model.RequestWithManager;

public class driver {
	public static void main (String[] args) {
		ArrayList<RequestWithManager> requests = new ArrayList<RequestWithManager>();
		ManagerAccountImpl dao = new ManagerAccountImpl();
		
		requests = dao.getallResolvedRequests();
		
		System.out.println(requests.get(1).getManager());
	}
}
