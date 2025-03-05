package com.dao;

import com.model.Candidat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CandidatDao {
    //Add candidat
    public void addCandidat(Candidat candidat){
            String sql = "insert into Candidat(nome,email) values(?,?)";
            try(Connection con = DBConnection.getConnection();
            PreparedStatement prstm = con.prepareStatement(sql);) {
                  prstm.setString(1,candidat.getNom());
                prstm.setString(2,candidat.getEmail());
                prstm.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }
    // get all candidat




}
