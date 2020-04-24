package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.model.EmployeeAccount;
import com.revature.model.ReimbursementRequest;
import com.revature.model.RequestWithManager;
import com.revature.utilities.ConnectionFactory;

public class ManagerAccountImpl implements ManagerAccountDao {

	Connection connection = null;
	PreparedStatement stmt = null;

	@Override
	public ArrayList<ReimbursementRequest> getPendingRequestsByManager(String manager) {
		ArrayList<ReimbursementRequest> pendingRequests = new ArrayList<ReimbursementRequest>();

		try {
			connection = ConnectionFactory.getConnection(); // open connection
			String sql = "Select * FROM manageremployeeview WHERE manager = ?"; // create query
			stmt = connection.prepareStatement(sql);

			stmt.setString(1, manager);
			ResultSet rs = stmt.executeQuery(); // place the results of the executed query into the result set

			while (rs.next()) {
				ReimbursementRequest request = new ReimbursementRequest();

				request.setAmount(rs.getString("amount"));
				request.setDescription(rs.getString("description"));
				request.setRequester(rs.getString("requester"));
				request.setReceipt(rs.getBytes("image"));
				request.setId(rs.getInt("id"));

				pendingRequests.add(request);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pendingRequests;
	}

	@Override
	public ArrayList<EmployeeAccount> getEmployees() {
		ArrayList<EmployeeAccount> employees = new ArrayList<EmployeeAccount>();

		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM reimbursementemployees";
			stmt = connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				EmployeeAccount employee = new EmployeeAccount();

				employee.setFirstName(rs.getString("FirstName"));
				employee.setLastName(rs.getString("LastName"));
				employee.setManager(rs.getString("manager"));
				employee.setUsername(rs.getString("username"));

				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employees;
	}

	@Override
	public ArrayList<ReimbursementRequest> getMyEmployeeRequests(String username) {

		ArrayList<ReimbursementRequest> myEmployeeRequests = new ArrayList<ReimbursementRequest>();

		try {
			connection = ConnectionFactory.getConnection(); // open connection
			String sql = "Select * FROM pendingrequests WHERE username = ?"; // create query
			stmt = connection.prepareStatement(sql);

			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery(); // place the results of the executed query into the result set

			// add all requests into request list
			while (rs.next()) {
				ReimbursementRequest request = new ReimbursementRequest();

				request.setAmount(rs.getString("amount"));
				request.setDescription(rs.getString("description"));
				request.setRequester(rs.getString("requester"));
				request.setReceipt(rs.getBytes("image"));

				myEmployeeRequests.add(request);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return myEmployeeRequests;
	}

	@Override
	public ArrayList<RequestWithManager> getallResolvedRequests() {
		ArrayList<RequestWithManager> requests = new ArrayList<RequestWithManager>();

		try {
			connection = ConnectionFactory.getConnection();
			String sql = "Select * FROM resolvedmanageremployee";
			stmt = connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				RequestWithManager request = new RequestWithManager();

				request.setAmount(rs.getString("amount"));
				request.setDescription(rs.getString("description"));
				request.setRequester(rs.getString("requester"));
				request.setReceipt(rs.getBytes("image"));
				request.setManager(rs.getString("manager"));
				request.setResolution(rs.getString("resolution"));

				requests.add(request);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return requests;
	}

	@Override
	public void resolveRequest(int id, String resolution) {
		ReimbursementRequest request = new ReimbursementRequest();

		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM pendingRequests where id = ?";
			stmt = connection.prepareStatement(sql);

			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				request.setAmount(rs.getString("amount"));
				request.setRequester(rs.getString("requester"));
				request.setDescription(rs.getString("description"));
				request.setReceipt(rs.getBytes("image"));
			}

			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			connection = ConnectionFactory.getConnection();
			String sql = "DELETE FROM pendingRequests where id = ?";
			stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "INSERT INTO resolvedrequests VALUES (?, ?, ?, ?, ?)";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, request.getAmount());
			stmt.setString(2, request.getRequester());
			stmt.setString(3, request.getDescription());
			stmt.setBytes(4, request.getReceipt());
			stmt.setString(5, resolution);
			
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	protected void closeResources() {

		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {

			System.out.println("Could not close statement!");
			e.printStackTrace();
		}

		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {

			System.out.println("Could not close connection!");
			e.printStackTrace();
		}

	}

	@Override
	public boolean isMyEmployee(String employeeUsername, String managerUsername) {
		connection = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM reimbursementemployees WHERE username = ? AND manager = ?";
		try {
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, employeeUsername);
			stmt.setString(2, managerUsername);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
