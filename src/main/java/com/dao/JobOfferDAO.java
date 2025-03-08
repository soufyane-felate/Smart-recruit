package com.dao;

import com.model.Candidature;
import com.model.JobOffer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobOfferDAO {
    public List<JobOffer> getAllOffers() throws SQLException {
        String sql = "SELECT * FROM OffreEmploi";
        Connection con = DBConnection.getConnection();
        List<JobOffer> jobOffers = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            JobOffer jobOffer = new JobOffer();
            jobOffer.setDate(rs.getDate("datePublication").toLocalDate());
            jobOffer.setTitle(rs.getString("titre"));
            jobOffer.setDescription(rs.getString("description"));
            jobOffers.add(jobOffer);
        }
        return jobOffers;
    }
    public void addCandidature(int idCandidat, int idOffreEmploi) throws SQLException {
        String sql = "INSERT INTO Candidature (idCandidat, idOffreEmploi, dateCandidature, statut) VALUES (?, ?, CURDATE(), 'En attente')";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCandidat);
            ps.setInt(2, idOffreEmploi);
            ps.executeUpdate();
        }
    }

    public List<Candidature> getAllCandidatures() throws SQLException {
        String sql = "SELECT * FROM Candidature";
        List<Candidature> candidatures = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Candidature candidature = new Candidature();
                candidature.setId(rs.getInt("id"));
                candidature.setIdCandidat(rs.getInt("idCandidat"));
                candidature.setIdOffreEmploi(rs.getInt("idOffreEmploi"));
                candidature.setDateCandidature(rs.getDate("dateCandidature").toLocalDate());
                candidature.setStatut(rs.getString("statut"));
                candidatures.add(candidature);
            }
        }
        return candidatures;
    }

    public void updateCandidatureStatus(int id, String status) throws SQLException {
        String sql = "UPDATE Candidature SET statut = ? WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, status);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    public void addOffer(){
        String sql = "";
    }
}
