<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page  import=java.sql.*;  %>
<%!
String uname = null;
String uage = null;
String uaddr =null;
Connection con = null;
Statement  stmt= null;
ResultSet rs =  null;
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%   
try{

uname  = ( String)request.getParameter("uname");
uage = request.getParameter("uage");
uaddr = request.getParameter("uaddr");
Class.forName("com.mysql.java.Driver");
con = DriverManager.getConnection("javas:mysql://localhost:3306/hibernatedb" ,"root","@Raman@Ladda@100");
stmt =  con.createStatement();
%>

</head>

<body>
<% 
rs= stmt.executeQuery("select *from users   where   name = " +uname +";");
if(rs.next()){
%>
	<jsp:forward page="existed.jsp"/>		
<% 	
}else{
	  int  r =    stmt.executeUpdate("insert into  users(uname , uage , uaddr)  values('" +uname+ "','"+uaddr 
			+""+");");
	  if(r>0)
	%>
	<jsp:forward page ="success.jsp" />
	<%
	else 
		%>
	    <jsp:forward page ="failure.jsp" />	
		<% 
	
}	
	
}catch(Exception  e){
	
	%>
    <jsp:forward page ="failure.jsp" />	
	<% 
}
%>

</body>
</html>