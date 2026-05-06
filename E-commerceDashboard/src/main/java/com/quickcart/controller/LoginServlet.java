package com.quickcart.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email.equals("ayush@cart.com") && password.equals("1234")) {

            response.sendRedirect("ProductServlet?msg=Login Successful");

        } else {

            request.setAttribute("errorMessage", "Invalid Email or Password");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}