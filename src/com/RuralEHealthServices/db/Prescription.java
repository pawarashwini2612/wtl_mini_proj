package com.RuralEHealthServices.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.RuralEHealthDBConnection.db.HeathDBConnection;


public class Prescription extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Prescription() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		String pgd = request.getParameter("pgd");
		String pcd = request.getParameter("pcd");
		String pnd = request.getParameter("pnd");
		String pod = request.getParameter("pod");
		
		
		try
		{
			Connection con = HeathDBConnection.getConnect();
			PreparedStatement ps = con.prepareStatement("insert into doctor values(?,?,?,?)");
			ps.setString(1, pgd);
			ps.setString(2, pcd);
			ps.setString(3, pnd);
			ps.setString(4, pod);
			
		
			int i = ps.executeUpdate();
			if(i>0)
			
			{
				response.sendRedirect("Pass.html");
			}
			else
			{
				response.sendRedirect("Fail.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	


}


