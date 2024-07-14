package auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginvalid
 */
@WebServlet("/loginvalid")
public class loginvalid extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	PrintWriter ou=response.getWriter();
		String name1=request.getParameter("Username");
		String pass1=request.getParameter("pass");
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");
		PreparedStatement ps1=con.prepareStatement("select * from register where name='"+name1+"' and pass='"+pass1+"'");
		ResultSet rs=ps1.executeQuery();

		if(rs.next())
		{
		int id=rs.getInt(1);
			
		HttpSession session=request.getSession();
		session.setAttribute("id",id);
ou.print("<html><body><script>alert('login sucessfull');</script></body></html>");
			
		RequestDispatcher rs1=request.getRequestDispatcher("inbox.jsp");
		rs1.include(request,response);
		}
		else
		{
			ou.print("<html><body><script>alert('login Un sucessfull');</script></body></html>");
		RequestDispatcher rs1=request.getRequestDispatcher("index.html");
		rs1.include(request,response);

		}

		}
		catch(Exception ee)
		{
		ee.printStackTrace();
		}
	
	}

}
