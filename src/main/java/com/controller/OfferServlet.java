package com.controller;

import com.dao.CandidatureDAO;
import com.dao.JobOfferDAO;
import com.model.Candidature;
import com.model.JobOffer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
@WebServlet("/OfferServlet")
public class OfferServlet extends HttpServlet {
    JobOfferDAO jobOfferDAO = new JobOfferDAO();
    CandidatureDAO candidatureDAO = new CandidatureDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<JobOffer> offers = jobOfferDAO.getAllOffers();
            req.setAttribute("offers", offers);

            List<Candidature> candidatures = candidatureDAO.getAllCandidatures();
            req.setAttribute("candidatures", candidatures);

            req.getRequestDispatcher("home.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        try {
            if ("postuler".equals(action)) {
                int idCandidat = Integer.parseInt(req.getParameter("idCandidat"));
                int idOffreEmploi = Integer.parseInt(req.getParameter("idOffreEmploi"));
                candidatureDAO.addCandidature(idCandidat, idOffreEmploi);
                try {
                    jobOfferDAO.addCandidature(idCandidat, idOffreEmploi);
                    resp.sendRedirect("listCondidatur.jsp");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } else if ("updateStatus".equals(action)) {
                int candidatureId = Integer.parseInt(req.getParameter("idCandidature"));
                String newStatus = req.getParameter("status");
                candidatureDAO.updateStatus(candidatureId, newStatus);
            }

            resp.sendRedirect("home.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
