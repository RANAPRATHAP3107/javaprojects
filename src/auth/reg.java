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

/**
 * Servlet implementation class reg
 */
@WebServlet("/reg")
public class reg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		PrintWriter ou=response.getWriter();
		String pass=request.getParameter("pass");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");
		PreparedStatement p=con.prepareStatement("insert into register(name,pass) values('"+name+"','"+pass+"')");
		int i=p.executeUpdate();
		
		if(i>0)
		{
			ou.print("<html><body><script>alert('regiser sucess');</script></body></html>");
			RequestDispatcher tst=request.getRequestDispatcher("index.html");
			tst.include(request, response);
		}
		else
		{
			ou.print("<html><body><script>alert('regiser unsucess');</script></body></html>");
			RequestDispatcher tst=request.getRequestDispatcher("index.html");	
			tst.include(request, response);
		}
		
		}
		catch(Exception ne)
		{
			ne.printStackTrace();
		}
		
		
		
	}

}
