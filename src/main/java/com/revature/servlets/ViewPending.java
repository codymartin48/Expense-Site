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
 * Servlet implementation class ViewPending
 */
public class ViewPending extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPending() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ArrayList<ReimbursementRequest> requests = new ArrayList<ReimbursementRequest>();
//		EmployeeAccountImpl dao = new EmployeeAccountImpl();
//		
//		requests = dao.getPendingList();
//		response.setContentType("application/json");
//		
//		ObjectMapper map = new ObjectMapper();
//		response.getWriter().write(map.writeValueAsString(requests));
		
		
		
		request.getRequestDispatcher("ViewPending.jsp").forward(request, response);
	}


}
