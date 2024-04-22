package com.RuralEHealthServices.db;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdminLogin() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
		
		String em = request.getParameter("email");
		String pass = request.getParameter("password");
		
		if(em.equals("admin@gmail.com") && pass.equals("admin"))
		{
			response.sendRedirect("AdminDashboard.html");
		}
		else
		{
			response.sendRedirect("AdminLogin.html");
		}
		
	}

}