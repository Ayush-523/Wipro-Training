

package com.ecomm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductDashboard
 */
@WebServlet(description = "Created to display all products", urlPatterns = { "/product" })
public class ProductDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       PrintWriter pw  ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDashboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		pw = response.getWriter();
	  
		ServletConfig cg = getServletConfig();
		String value = cg.getInitParameter("Products");
	    pw.println("Total Product Count :" + value);
		
	    
		 ServletContext sc = getServletContext();
		 String cname = sc.getInitParameter("company_name");
		 pw.println("Your company name is :"+ cname);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

