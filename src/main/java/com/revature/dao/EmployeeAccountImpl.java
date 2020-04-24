package com.revature.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.revature.model.EmployeeAccount;
import com.revature.model.ReimbursementRequest;
import com.revature.utilities.ConnectionFactory;

public class EmployeeAccountImpl implements EmployeeAccountDao {

	Connection connection = null;
	PreparedStatement stmt = null;

	@Override
	public EmployeeAccount loginEmployee(String username, String password) {

		EmployeeAccount employee = new EmployeeAccount();

		try {
			connection = ConnectionFactory.getConnection();
			String sql = "Select * FROM reimbursementemployees where username = ? AND password = ?";
			stmt = connection.prepareStatement(sql);

			stmt.setString(1, username);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();

			// return null if no matching username and password is found
			if (!rs.next()) {
				return null;
			}

			employee.setFirstName(rs.getString("firstname"));
			employee.setLastName(rs.getString("lastname"));
			employee.setUsername(rs.getString("username"));
			employee.setPassword(rs.getString("password"));
			employee.setManager(rs.getString("manager"));
			employee.setIsManager(rs.getBoolean("ismanager"));

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return employee;
	}

	@Override
	public void submitReimbursementRequest(String amount, String requester, String description,
			InputStream receiptStream) {

		try {
			connection = ConnectionFactory.getConnection();
			String sql = "INSERT INTO pendingrequests VALUES (?, ?, ?, ?)";

			stmt = connection.prepareStatement(sql);
			stmt.setString(1, amount);
			stmt.setString(2, requester);
			stmt.setString(3, description);

			byte[] receiptArray;

			try {
				receiptArray = IOUtils.toByteArray(receiptStream);
				stmt.setBytes(4, receiptArray);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<ReimbursementRequest> getPendingList() {

		List<ReimbursementRequest> pendingRequests = new ArrayList<ReimbursementRequest>();

		try {
			connection = ConnectionFactory.getConnection(); // open connection
			String sql = "Select * FROM pendingrequests"; // create query
			stmt = connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery(); // place the results of the executed query into the result set

			// add all results into the customers list
			while (rs.next()) {
				ReimbursementRequest request = new ReimbursementRequest();

				request.setAmount(rs.getString("amount"));
				request.setDescription(rs.getString("description"));
				request.setRequester(rs.getString("requester"));
				request.setReceipt(rs.getBytes("image"));

				pendingRequests.add(request);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pendingRequests;
	}

	@Override
	public ArrayList<ReimbursementRequest> getResolvedList() {

		ArrayList<ReimbursementRequest> resolvedRequests = new ArrayList<ReimbursementRequest>();

		try {
			connection = ConnectionFactory.getConnection(); // open connection
			String sql = "Select * FROM resolvedRequests"; // create query
			stmt = connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery(); // place the results of the executed query into the result set

			// add all results into the customers list
			while (rs.next()) {
				ReimbursementRequest request = new ReimbursementRequest();

				request.setAmount(rs.getString("amount"));
				request.setDescription(rs.getString("description"));
				request.setRequester(rs.getString("requester"));
				request.setReceipt(rs.getBytes("image"));

				resolvedRequests.add(request);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resolvedRequests;
	}

	@Override
	public void editInfo(String firstName, String lastName, String username) {
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "UPDATE reimbursementemployees SET firstname = ?, lastname = ? WHERE username = ?";
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setString(3, username);
			
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<ReimbursementRequest> getMyPendingList(String username) {

		ArrayList<ReimbursementRequest> myPending = new ArrayList<ReimbursementRequest>();

		try {
			connection = ConnectionFactory.getConnection(); // open connection
			String sql = "Select * FROM pendingrequests WHERE requester = ?"; // create query
			stmt = connection.prepareStatement(sql);

			stmt.setString(1, username);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				ReimbursementRequest request = new ReimbursementRequest();
				request.setAmount(rs.getString("amount"));
				request.setDescription(rs.getString("description"));
				request.setRequester(rs.getString("requester"));
				request.setReceipt(rs.getBytes("image"));
				myPending.add(request);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myPending;
	}

	@Override
	public ArrayList<ReimbursementRequest> getMyResolvedList(String username) {

		ArrayList<ReimbursementRequest> myResolved = new ArrayList<ReimbursementRequest>();

		try {
			connection = ConnectionFactory.getConnection(); // open connection
			String sql = "Select * FROM resolvedrequests WHERE requester = ?"; // create query
			stmt = connection.prepareStatement(sql);

			stmt.setString(1, username);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				ReimbursementRequest request = new ReimbursementRequest();
				request.setAmount(rs.getString("amount"));
				request.setDescription(rs.getString("description"));
				request.setRequester(rs.getString("requester"));
				request.setReceipt(rs.getBytes("image"));
				myResolved.add(request);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myResolved;
	}

	@Override
	public EmployeeAccount viewInfo(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
