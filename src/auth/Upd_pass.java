package auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Upd_pass
 */
@WebServlet("/Upd_pass")
public class Upd_pass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String up_pass=request.getParameter("pss");
	String id=request.getParameter("id");
	PrintWriter ou=response.getWriter();
	System.out.println(up_pass+"     "+id);
	
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");
	PreparedStatement ps1=con.prepareStatement("update register set pass='"+up_pass+"' where id='"+id+"'");
	int i=ps1.executeUpdate();
	if(i>0)
	{
		ou.print("<html><body><script>alert('update pass sucessfull');</script></body></html>");
		
		HttpSession session=request.getSession();
		session.setAttribute("id",id);
		RequestDispatcher rs1=request.getRequestDispatcher("viewRecords.jsp");
		rs1.include(request,response);
	}
	else
	{
		ou.print("<html><body><script>alert('password Unsucessfull');</script></body></html>");
		
		RequestDispatcher rs1=request.getRequestDispatcher("inbox.jsp");
		rs1.include(request,response);
	}
	
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
	}

}
