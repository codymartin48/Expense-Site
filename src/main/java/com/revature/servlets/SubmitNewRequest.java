package com.revature.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.revature.dao.EmployeeAccountImpl;

/**
 * Servlet implementation class SubmitNewRequest
 */
@MultipartConfig(maxFileSize = 16177215) 
public class SubmitNewRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitNewRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("ViewPending.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeAccountImpl dao = new EmployeeAccountImpl();
		HttpSession session = request.getSession();
		
		String username = (String) session.getAttribute("username");
		String amount = request.getParameter("amount");
		String description = request.getParameter("description");
		
		Part part = request.getPart("image");
		String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
		InputStream input = null;
		
		if(part != null) {
			input = part.getInputStream();
		}
		
		dao.submitReimbursementRequest(amount, username, description, input);
		
		doGet(request,response);
	}

}
