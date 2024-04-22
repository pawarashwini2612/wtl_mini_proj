package com.RuralEHealthServices.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.RuralEHealthDBConnection.db.HeathDBConnection;

public class DPrescription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DPrescription() {
        super();
            }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		String pid = request.getParameter("pid");
		String pname = request.getParameter("pname");
		String prescription = request.getParameter("prescription");
		
		
		try
		{
			Connection con = HeathDBConnection.getConnect();
			PreparedStatement ps = con.prepareStatement("insert into prescription values(?,?,?)");
			ps.setString(1, pid);
			ps.setString(2, pname);
			ps.setString(3, prescription);
			
		
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


