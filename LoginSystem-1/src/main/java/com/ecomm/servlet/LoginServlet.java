
package com.ecomm.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet(description = "Login servlet is created for sign in purpose", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter out;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
            }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");
		
		 out  = response.getWriter();
		
		 out.println("<br />");
		
		 out.println("<br>You request is submitted !<br />");
	
	
		
	
		if(pass.equals("admin"))
		{
			out.println("Hi" + mail + "You have successfully logged in");
		}
		else 
		{
			
			out.println("Incorrect password you have entered");
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
