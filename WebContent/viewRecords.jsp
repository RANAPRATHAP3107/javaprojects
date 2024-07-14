<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
int id=(int)session.getAttribute("ids");
%>
<table>
<tr>
<th>ID</th>
<th>NAME</th>
<th>PASSWORD</th>

<th>Action<th>
</tr>

<%
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");
PreparedStatement ps1=con.prepareStatement("select * from register where id='"+id+"'");
ResultSet rs=ps1.executeQuery();

while(rs.next())
{

%>

<tr>
<td><%=rs.getString(1)%></td>
<td><%=rs.getString(2)%></td>
<td><%=rs.getString(3)%></td>

<td>
<form action="Upd_pass" method="post">
<input type="text" name="pss">
<input type="hidden" name="id" value=<%=rs.getString(1)%>>
<button type="submit">Update</button>
</form>
</td>




<tr>
<%}

}
catch(Exception e)
{
	e.printStackTrace();
}
%>

</table>
</body>
</html>