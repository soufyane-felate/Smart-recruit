package com.controller;

import com.dao.CandidatureDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/updateStatus")
public class StatusUpdateServlet extends HttpServlet {
    CandidatureDAO candidatureDAO = new CandidatureDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String statut = req.getParameter("statut");

            candidatureDAO.updateCandidatureStatus(id, statut);

            resp.sendRedirect("listeCandidature.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}