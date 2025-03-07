package com.controller;

import com.dao.JobOfferDAO;
import com.model.JobOffer;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AddOfferServlet extends HttpServlet {
    JobOfferDAO jobOfferDAO = new JobOfferDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null || action.isEmpty()){
            try {
                List<JobOffer> offers = jobOfferDAO.getAllOffers();
                req.getRequestDispatcher("home.jsp");
                req.setAttribute("offers", offers);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response){

    }
}
