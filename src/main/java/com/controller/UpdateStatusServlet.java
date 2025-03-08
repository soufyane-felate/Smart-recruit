package com.controller;

import com.dao.JobOfferDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateStatusServlet extends HttpServlet {
    JobOfferDAO jobOfferDAO = new JobOfferDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String status = request.getParameter("status");

        try {
            jobOfferDAO.updateCandidatureStatus(id, status);
            response.sendRedirect("listCondidatur.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
