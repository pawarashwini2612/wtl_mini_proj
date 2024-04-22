package com.RuralEHealthDBConnection.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class HeathDBConnection {
	static Connection con=null;
	public static Connection getConnect(){
	
		try
		{
			if(con==null){
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ehealthcare","root","");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return(con);
	}
}




