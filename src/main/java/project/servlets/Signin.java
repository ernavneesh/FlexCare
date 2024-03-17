package project.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Signin
 */
@WebServlet("/Signin")
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw= response.getWriter();
		
		String uemail=request.getParameter("uemail");
		String upass=request.getParameter("upassword");
		HttpSession session=request.getSession();
				

		RequestDispatcher dispatcher =null;
		
		
		//load the jdbc driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//create a new connection
		
		try (Connection con = DriverManager.getConnection("jdbc:mysql:///projectdb", "root", "root1234");
		        PreparedStatement st = con.prepareStatement("SELECT * FROM user WHERE email=? and password=?"))
		  {	 
			st.setString(1, uemail);
		    st.setString(2, upass);
		    ResultSet rs = st.executeQuery();

		    if (rs.next()) {
		        
		        session.setAttribute("fname", rs.getString("firstname"));
		        dispatcher= request.getRequestDispatcher("session.jsp");
		        
		    } 
		    else {
		    	session.setAttribute("status","failed");
		        dispatcher= request.getRequestDispatcher("login.jsp");
		       
		        
		    }
		    dispatcher.forward(request, response);
		    
		} catch (SQLException se) {
		    pw.println(se.getMessage());
		    se.printStackTrace();
		} catch (Exception e) {
		    pw.println(e.getMessage());
		    e.printStackTrace();
		}

		pw.close();
		
	
	}

}
