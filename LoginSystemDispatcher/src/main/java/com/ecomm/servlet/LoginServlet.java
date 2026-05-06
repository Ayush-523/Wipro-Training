package com.ecomm.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "Login servlet is created for sign in purpose", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter out;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		 out  = response.getWriter();
		
		 out.println("<br />");
		
		 out.println("<br>You request is submitted !<br />");
		 
		 ServletContext sc = getServletContext();
		 String cname = sc.getInitParameter("company_name");
		 out.println("Your company name is :"+ cname);
		 
		 out.println("<br>***********<br/>");
	
		if(username.equalsIgnoreCase("admin") && password.equals("1234") )
		{
			// setting the value in an object named as user
			request.setAttribute("user" , username);
			out.println("Hi" + " " + username + "You have successfully logged in");
			
//			RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
//			rd.forward(request, response);
			
			

			
			RequestDispatcher rd = request.getRequestDispatcher("/product");
			rd.forward(request, response);
		}
		else 
		{
			
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
