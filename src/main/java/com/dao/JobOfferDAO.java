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
        JobOffer jobOffer = new JobOffer();
        while (rs.next()){
            JobOffer.setDate(rs.getDate("datePublication").toLocalDate());
            jobOffer.setTitle(rs.getString("title"));
            jobOffer.setDescription(rs.getString("description"));
            jobOffers.add(jobOffer);
        }
        return jobOffers;
    }

    public void addOffer(){
        String sql = "";
    }
}
