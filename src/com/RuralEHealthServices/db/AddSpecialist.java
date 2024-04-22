package com.RuralEHealthServices.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.RuralEHealthDBConnection.db.HeathDBConnection;

public class AddSpecialist extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddSpecialist() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		String sid =request.getParameter("sid");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String sname = request.getParameter("sname");
		String mobno = request.getParameter("mobno");
		
		String city = request.getParameter("city");
		String special = request.getParameter("special");
		String dtreat = request.getParameter("dtreat");
	
		try
		{
			Connection con = HeathDBConnection.getConnect();
			PreparedStatement ps = con.prepareStatement("insert into specialist values(?,?,?,?,?,?,?,?)");
			ps.setString(1, sid);
			ps.setString(2, email);
			ps.setString(3,password);
			ps.setString(4, sname);
			ps.setString(5, mobno);
			
			ps.setString(6, city);
			ps.setString(7, special);
			ps.setString(8, dtreat);
		
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
