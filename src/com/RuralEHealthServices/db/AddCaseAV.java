package com.RuralEHealthServices.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.RuralEHealthDBConnection.db.HeathDBConnection;

public class AddCaseAV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddCaseAV() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		PrintWriter out = response.getWriter();
		String pid =request.getParameter("pid");
		String pname = request.getParameter("pname");
		String page = request.getParameter("page");
		String pgender = request.getParameter("pgender");
		String paddr = request.getParameter("paddr");
		String mobno = request.getParameter("mobno");
		String symp1 = request.getParameter("symp1");
		String symp2 = request.getParameter("symp2");
		String symp3 = request.getParameter("symp3");
		//String assignedSpecialist=null;
		String assignedSpecialist=getSpecialist(symp1,symp2,symp3);
		//response.setContentType("Pass/html");
		
		//out.println("<html><body>");
		out.println("\nBased on the symptoms,you should consult a : "+ assignedSpecialist );
		//out.println("</html></body>");
		
		try
		{
			Connection con = HeathDBConnection.getConnect();
			PreparedStatement ps = con.prepareStatement("insert into aarogyavibhag values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1, pid);
			ps.setString(2, pname);
			ps.setString(3, page);
			ps.setString(4, pgender);
			ps.setString(5, paddr);
			ps.setString(6, mobno);
			ps.setString(7,symp1);
			ps.setString(8, symp2);
			ps.setString(9, symp3);
		
			int i = ps.executeUpdate();
			if(i>0)
			
			{
				//out.println("Specialist Assigned successfully !!!!"+assignedSpecialist);
				//response.sendRedirect("Pass.html");
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
	private String getSpecialist(String symp1,String symp2,String symp3)
	{
		if(symp1.equals("fever") && symp2.equals("cough") && symp3.equals("cold"))
			return "General Practioner";
		else if(symp1.equals("chest pain") && symp2.equals("shortness of breath") && symp3.equals("nausea")){
			return "Cardiologist";
		}
		else if(symp1.equals("memory disturbance") && symp2.equals("loss of consiquence") && symp3.equals("seizures")){
			return "Neurologist";
		}
		else if(symp1.equals("chest pain") && symp2.equals("shortness of breath") && symp3.equals("nausea")){
			return "Cardiologist";
		}
		
		else{
			return "General Practioner";
		}
		
	}


}


