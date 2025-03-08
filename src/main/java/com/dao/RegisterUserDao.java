package com.dao;

import com.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterUserDao {
    public void addUser(User user) throws SQLException {
        String query = "INSERT INTO Utilisateur(nom,email, motDePasse, role) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement prstm = con.prepareStatement(query)) {
           prstm.setString(1, user.getNom());
            prstm.setString(2, user.getEmail());
            prstm.setString(3, user.getMotDePasse());
            prstm.setString(4, user.getRole().name());

            prstm.executeUpdate();

        }
    }

}



