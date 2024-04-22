package com.RuralEHealthServices.db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.RuralEHealthDBConnection.db.HeathDBConnection;

public class AddAarogyaVibhag extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddAarogyaVibhag() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		String aid =request.getParameter("aid");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String mobno = request.getParameter("mobno");
		
		String village = request.getParameter("village");
		String district = request.getParameter("district");
	
		try
		{
			Connection con = HeathDBConnection.getConnect();
			PreparedStatement ps = con.prepareStatement("insert into admin values(?,?,?,?,?,?,?)");
			ps.setString(1, aid);
			ps.setString(2, email);
			ps.setString(3,password);
			ps.setString(4, name);
			ps.setString(5, mobno);
			
			ps.setString(6, village);
			ps.setString(7, district);
		
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
