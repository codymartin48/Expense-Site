package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeAccountImpl;
import com.revature.model.EmployeeAccount;

/**
 * Servlet implementation class EmployeeHome
 */
public class EmployeeHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeAccountImpl dao = new EmployeeAccountImpl();
		EmployeeAccount employee = new EmployeeAccount();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		employee = dao.loginEmployee(username, password);
		
		
		
		if(employee == null) {
			request.getRequestDispatcher("employeeLogin.jsp").forward(request, response);
			return;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("username", employee.getUsername());
		session.setAttribute("firstname", employee.getFirstName());
		session.setAttribute("lastname", employee.getLastName());
		session.setAttribute("manager", employee.getManager());
		session.setAttribute("ismanager", employee.getIsManager());
		
		if(employee.getIsManager()) {
			request.getRequestDispatcher("managerHome.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("employeeHome.jsp").forward(request, response);
		}
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}

	
