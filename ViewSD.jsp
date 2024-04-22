<%@page import ="java.sql.*" %>
<%@page import ="com.RuralEHealthServices.db.*" %>
<%@page import ="com.RuralEHealthDBConnection.db.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
     
<head>  
<meta name="viewport" content="width=device-width, initial-scale=1">  
<title> Login Page </title>  
<style>
*{
    margin: 50;
    padding: 50;
    font-family: Arial ,sans-serif;
    box-sizing: border-box;
}
.container{
    width: 100%;
    height: 130vh;
    border: 3px solid black;   
    
    
   
}
h1{
	color:black;
	 
	
} 
h2{
	color:blue;

}  
Body {  
  background: url(images/1u.jpg);
  background-size:cover;
  display:center;
  text-align:center;
  align-items: center;
  justify-content:center;

  height:100vh;
  margin:0;
   
}  
button {  
		font-size:15px; 
  	   background-color:#3498db; 
  	   
       display:inline-block;
       text-align:center;
       
       align-items:center;
       justify-content:center;
       width: 20%;
       height:9vh;
         
        color: white;   
        padding: 15px;   
        margin: 10px 0px;   
        cursor: pointer; 
        
         } 
  
 form {
 		display:inline-block;
 		text-align:left;
 		align-items:center;
       	justify-content:center;
 		width :70%;
 		height: 60vh;
 		
    }   
 input[type=text], input[type=password] {   
 		
        width: 90%;   
        margin: 8px 0;  
        padding: 12px 20px;   
		display:inline-block;
 		text-align:left;
        border: 2px solid grey;   
        box-sizing: content-box;  
         
    } 
    input:hover {   
        opacity: 0.7; 
       	
       
    }  
 button:hover {   
        opacity: 0.7; 
        background-color:#45a049;
        display:center;
        border: 3px solid yellowgreen; 
        border-radius: 20px;  
    }   
 
a{
	   font-size:15px; 
  	   background-color:#3498db; 
       display:inline-block;
       text-align:center;
        border: 2px solid black; 
       align-items:center;
       justify-content:center;
       width: 20%;
       height:9vh;
         
        color: white;   
        padding: 15px;   
        margin: 10px 0px;   
 		
        cursor: pointer; 
}
 a:hover {   
        opacity: 0.7; 
        background-color:#45a049;
        display:center;
        border: 3px solid yellowgreen; 
        border-radius: 20px; 
    }   
     
.container {
 		
 	
        padding: 25px;   
  		background:linear-gradient(135deg,floralwhite,ghostwhite,floralwhite,ghostwhite,floralwhite);
    }  
</style>    
</head>    
<body>    
    <center> <h1> + E-Health Care </h1> </center>   
    <center> <h3> Welcome To E-Health Care</h3> </center>  
    
    <form action="ViewSD.jsp" >
        <div class="container">   
            <label>Specialist Name : </label>   
            <input type="text" placeholder="Enter Specialist name" name="sname" required>  
            

           
            <button type="submit">Search Specialist </button>   
            <a href ="AdminDashboard.html">Home</a>     
        </div>   
    </form> 
    
    
    <%
    	String sname=request.getParameter("sname");
    	if(sname!=null)
    	{
    		try
    		{
    			Connection con=HeathDBConnection.getConnect();
    			PreparedStatement pstmt=con.prepareStatement("select * from specialist where sname=?");
    			pstmt.setString(1,sname);
    			ResultSet rs=pstmt.executeQuery();
    			while(rs.next())
    			{
    %>				<h3>Specialist ID : <%=rs.getString(1)%></h3>
    				<h3>Email : <%=rs.getString(2)%></h3>
    				<h3>Password : <%=rs.getString(3)%></h3>
    				<h3>Name Of Specialist : <%=rs.getString(4)%></h3>
    				<h3>Mobile Number : <%=rs.getString(5)%></h3>
    				<h3>City : <%=rs.getString(6)%></h3>
    				<h3>Specialization : <%=rs.getString(7)%></h3>
    				<h3>Diseased Treat : <%=rs.getString(8)%></h3>
    				<a href="DeleteSD.jsp?sname=<%=rs.getString(1)%>">Delete</a>
    <% 
    			}
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    	}
    %> 
       
</body>     
</html>
