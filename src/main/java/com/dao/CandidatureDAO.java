package com.dao;
import com.model.Candidature;
import java.sql.*;
        import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CandidatureDAO {

    public void addCandidature(int idCandidat, int idOffreEmploi) throws SQLException {
        String sql = "INSERT INTO Candidature (idCandidat, idOffreEmploi, dateCandidature) VALUES (?, ?, ?)";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idCandidat);
        ps.setInt(2, idOffreEmploi);
        ps.setDate(3, Date.valueOf(LocalDate.now()));
        ps.executeUpdate();
    }

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
        return candidatures;
    }

    public void updateStatus(int candidatureId, String newStatus) throws SQLException {
        String sql = "UPDATE Candidature SET statut = ? WHERE id = ?";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, newStatus);
        ps.setInt(2, candidatureId);
        ps.executeUpdate();
    }
}
