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
    height: 40vh;
    border: 3px solid black;   
    
    
   
}
h1{
	color:black;
	 
	
} 
h3{
	color:black;
	display:center;
 		
 		align-items:center;
       	justify-content:center;
 		margin:1px;
 		font-size:1.1em;
 		color:#333;
	

}  
Body {  
  background: url(images/1u.jpg);
  background-size:cover;
  display:center;
  text-align:center;
  align-items: center;
  justify-content:center;
  height:50vh;
  margin:0;
   
}  
button {  
		font-size:15px; 
  	   background-color:#3498db; 
       display:inline-block;
       text-align:center;
       
       align-items:center;
       justify-content:center;
       width: 30%;
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
 		width :50%;
 		height: 50vh;
 		
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
  .cancelbtn { 
  		  
        width: auto;   
        padding: 10px 18px;  
        margin: 10px 5px;  
        
    }   
a{
	   font-size:15px; 
  	   background-color:#3498db; 
       display:inline-block;
       text-align:center;
       
       align-items:center;
       justify-content:center;
       width: 20%;
       height:9vh;
        border : 2px solid Black;
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
    <center> <h3> Welcome Doctor</h3> </center>  
    
    <form action="SDPrescription.jsp" >
        <div class="container">   
            <label>Patient Name : </label>   
            <input type="text" placeholder="Enter Patient name" name="pname" required>  

            <button type="submit">Search Case</button>   
            <a href ="AVDashboard.html">Home</a>     
        </div>   
    </form> 
    
    
    <%
    	String pname=request.getParameter("pname");
    	if(pname!=null)
    	{
    		try
    		{
    			Connection con=HeathDBConnection.getConnect();
    			PreparedStatement pstmt=con.prepareStatement("select * from aarogyavibhag where pname=?");
    			pstmt.setString(1,pname);
    			ResultSet rs=pstmt.executeQuery();
    			while(rs.next())
    			{
    %>				<h3>Patient ID : <%=rs.getString(1)%></h3>
    				<h3>Patient Name : <%=rs.getString(2)%></h3>
    				<h3>Patient Age : <%=rs.getString(3)%></h3>
    				<h3>Patient Gender : <%=rs.getString(4)%></h3>
    				<h3>Patient Address : <%=rs.getString(5)%></h3>
    				<h3>Mobile Number : <%=rs.getString(6)%></h3>
    				<h3>Symptom 1 : <%=rs.getString(7)%></h3>
    				<h3>Symptom 2 : <%=rs.getString(8)%></h3>
    				<h3>Symptom 3 : <%=rs.getString(9)%></h3>
    				<a href="DeleteCase.jsp?pname=<%=rs.getString(1)%>">Delete</a>
    				<a href="SDPrescription.html?pid=<%=rs.getString(1)%>&pname=<%=rs.getString(2)%>&comments=<%=rs.getString(3)%>">Add Prescription</a>
    				<a href="SDComment.html?pid=<%=rs.getString(1)%>&pname=<%=rs.getString(2)%>&comments=<%=rs.getString(3)%>">Add Comments</a>
    				
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
