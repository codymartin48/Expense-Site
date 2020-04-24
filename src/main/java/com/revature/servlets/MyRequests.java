package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeAccountImpl;
import com.revature.model.ReimbursementRequest;

/**
 * Servlet implementation class MyRequests
 */
public class MyRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyRequests() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ReimbursementRequest> requests = new ArrayList<ReimbursementRequest>();
		EmployeeAccountImpl dao = new EmployeeAccountImpl();
		String username = (String) request.getSession().getAttribute("username");
		
		requests = dao.getMyPendingList(username);
		response.setContentType("application/json");
		
		ObjectMapper map = new ObjectMapper();
		response.getWriter().write(map.writeValueAsString(requests));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
