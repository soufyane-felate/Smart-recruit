package com.dao;

import com.model.Emploi;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OffreDao {
    public List<Emploi> getEmploi() {
        List<Emploi> emploiList = new ArrayList<>();
        String sql = "SELECT * FROM OffreEmploi";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Emploi emploi = new Emploi();
                emploi.setTitre(rs.getString("titre"));
                emploi.setDescription(rs.getString("description"));
                emploi.setDatePublication(rs.getString("datePublication"));
                emploiList.add(emploi);
                System.out.println(emploi);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return emploiList;
    }
}
