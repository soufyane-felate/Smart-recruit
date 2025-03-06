package com.controller;

import com.model.JobOffer;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddOfferServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        String title = request.getParameter("jobTitle");
        String description = request.getParameter("jobDescription");
        JobOffer jobOffer = new JobOffer();
        jobOffer.setTitle(title);
        jobOffer.setDescription(description);
    }
}
