package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ManagerAccountImpl;
import com.revature.model.RequestWithManager;

/**
 * Servlet implementation class AllEmployeesResolvedRequests
 */
public class AllEmployeesResolvedRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AllEmployeesResolvedRequests() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<RequestWithManager> requests = new ArrayList<RequestWithManager>();
		ManagerAccountImpl dao = new ManagerAccountImpl();

		requests = dao.getallResolvedRequests();
		response.setContentType("application/json");

		ObjectMapper map = new ObjectMapper();
		response.getWriter().write(map.writeValueAsString(requests));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
