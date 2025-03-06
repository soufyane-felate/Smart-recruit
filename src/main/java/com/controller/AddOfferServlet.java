package com.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddOfferServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        String title = request.getParameter("jobTitle");
        String description = request.getParameter("jobDescription");
        
    }
}
