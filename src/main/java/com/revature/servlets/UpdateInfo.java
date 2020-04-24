package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeAccountImpl;

/**
 * Servlet implementation class UpdateInfo
 */
public class UpdateInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInfo() {
        super();
        // TODO Auto-generated constructor stub
}
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
    	request.getRequestDispatcher("ViewInfo.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeAccountImpl dao = new EmployeeAccountImpl();
		HttpSession session = request.getSession();
		
		String username = (String) session.getAttribute("username");
		System.out.println(username);
		String firstName = (String) request.getParameter("firstname");
		System.out.println(firstName);
		String lastName = (String) request.getParameter("lastname");
		session.setAttribute("firstname", firstName);
		session.setAttribute("lastname", lastName);
		
		dao.editInfo(firstName, lastName, username);
		
		
		
		doGet(request, response);
	}

}
