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
/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private static final String insert_query="INSERT INTO USER(FIRSTNAME,LASTNAME,EMAIL,PASSWORD)VALUES(?,?,?,?)";
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("this was invoked");
		PrintWriter pw= response.getWriter();
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String email=request.getParameter("email");
		String pass=request.getParameter("password");
		String cpass=request.getParameter("confirm_password");

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
		        PreparedStatement stmt1 = con.prepareStatement("SELECT email FROM user WHERE email=?");
		        PreparedStatement stmt = con.prepareStatement(insert_query)) {

		    stmt1.setString(1, email);
		    ResultSet rs = stmt1.executeQuery();
		    System.out.println(rs.next());
		    if (rs.next()) {
		        // If the email exists in the database
		        System.out.println("Email is already registered");
		        request.setAttribute("status", "failed");
		    } else {
		        // If the email doesn't exist, proceed with insertion
		        stmt.setString(1, fname);
		        stmt.setString(2, lname);
		        stmt.setString(3, email);
		        stmt.setString(4, pass);
		        
		        int count = stmt.executeUpdate();

		        if (count > 0) {
		            request.setAttribute("status", "success");
		        } else {
		            request.setAttribute("status", "failed");
		        }
		        
		    }
		    dispatcher = request.getRequestDispatcher("login.jsp");
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
