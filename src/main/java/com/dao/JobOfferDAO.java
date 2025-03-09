package com.dao;

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
            jobOffer.setId(rs.getInt("id")); // Make sure we're setting the ID
            jobOffer.setDate(rs.getDate("datePublication").toLocalDate());
            jobOffer.setTitle(rs.getString("titre"));
            jobOffer.setDescription(rs.getString("description"));
            jobOffers.add(jobOffer);
        }

        rs.close();
        ps.close();
        con.close();

        return jobOffers;
    }

    public JobOffer getOfferById(int id) throws SQLException {
        String sql = "SELECT * FROM OffreEmploi WHERE id = ?";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        JobOffer jobOffer = null;
        if (rs.next()) {
            jobOffer = new JobOffer();
            jobOffer.setId(rs.getInt("id"));
            jobOffer.setDate(rs.getDate("datePublication").toLocalDate());
            jobOffer.setTitle(rs.getString("titre"));
            jobOffer.setDescription(rs.getString("description"));
        }

        rs.close();
        ps.close();
        con.close();

        return jobOffer;
    }

    public void addOffer(JobOffer offer) throws SQLException {
        String sql = "INSERT INTO OffreEmploi (titre, description, datePublication, idRecruteur) VALUES (?, ?, ?, ?)";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, offer.getTitle());
        ps.setString(2, offer.getDescription());
        ps.setDate(3, java.sql.Date.valueOf(offer.getDate()));
        ps.setInt(4, 1);

        ps.executeUpdate();

        ps.close();
        con.close();
    }
}