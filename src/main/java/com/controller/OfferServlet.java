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
import java.time.LocalDate;
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

        if ("postuler".equals(action)) {
            try {
                int idCandidat = Integer.parseInt(req.getParameter("idCandidat"));
                int idOffreEmploi = Integer.parseInt(req.getParameter("idOffreEmploi"));

                System.out.println("Trying to add candidature with:");
                System.out.println("idCandidat: " + idCandidat);
                System.out.println("idOffreEmploi: " + idOffreEmploi);

                JobOffer offer = jobOfferDAO.getOfferById(idOffreEmploi);
                if (offer == null) {
                    System.out.println("Job offer with ID " + idOffreEmploi + " does not exist!");
                    req.setAttribute("errorMessage", "L'offre d'emploi sélectionnée n'existe pas.");
                    doGet(req, resp);
                    return;
                }

                // Create a new candidature
                Candidature candidature = new Candidature();
                candidature.setIdCandidat(idCandidat);
                candidature.setIdOffreEmploi(idOffreEmploi);
                candidature.setDateCandidature(LocalDate.now());
                candidature.setStatut("En attente");

                candidatureDAO.addCandidature(candidature);

               // resp.sendRedirect("listeCandidature.jsp");

                req.setAttribute("successMessage", "Votre candidature a été envoyée avec succès !");
                doGet(req, resp);


            } catch (SQLException e) {
                System.err.println("SQL Exception: " + e.getMessage());
                e.printStackTrace();
                throw new RuntimeException(e);
            } catch (Exception e) {
                System.err.println("General Exception: " + e.getMessage());
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}