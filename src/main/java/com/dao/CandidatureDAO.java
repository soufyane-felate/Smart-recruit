package com.dao;

import com.model.Candidature;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CandidatureDAO {
    public List<Candidature> getAllCandidatures() throws SQLException {
        String sql = "SELECT * FROM Candidature";
        Connection con = DBConnection.getConnection();
        List<Candidature> candidatures = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Candidature candidature = new Candidature();
            candidature.setId(rs.getInt("id"));
            candidature.setIdCandidat(rs.getInt("idCandidat"));
            candidature.setIdOffreEmploi(rs.getInt("idOffreEmploi"));
            candidature.setDateCandidature(rs.getDate("dateCandidature").toLocalDate());
            candidature.setStatut(rs.getString("statut"));
            candidatures.add(candidature);
        }

        rs.close();
        ps.close();
        con.close();

        return candidatures;
    }

    public void addCandidature(Candidature candidature) throws SQLException {
        String sql = "INSERT INTO Candidature (idCandidat, idOffreEmploi, dateCandidature, statut) VALUES (?, ?, ?, ?)";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, candidature.getIdCandidat());
        ps.setInt(2, candidature.getIdOffreEmploi());
        ps.setDate(3, Date.valueOf(candidature.getDateCandidature()));
        ps.setString(4, candidature.getStatut());

        ps.executeUpdate();

        ps.close();
        con.close();
    }

    // Add method to update status
    public void updateCandidatureStatus(int id, String status) throws SQLException {
        String sql = "UPDATE Candidature SET statut = ? WHERE id = ?";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, status);
        ps.setInt(2, id);

        ps.executeUpdate();

        ps.close();
        con.close();
    }
}