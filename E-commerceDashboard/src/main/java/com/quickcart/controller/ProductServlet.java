package com.quickcart.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<String> products = Arrays.asList(
                "Macbook Neo",
                "Iphone 17",
                "Airpods Pro"
        );

        request.setAttribute("products", products);

        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }
}