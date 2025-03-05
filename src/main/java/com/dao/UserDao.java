package com.dao;

import com.model.Role;
import com.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
    public void addUser(User user) throws SQLException {
        String query = "INSERT INTO Utilisateur(email, motDePasse, role) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement prstm = con.prepareStatement(query)) {

            prstm.setString(1, user.getEmail());
            prstm.setString(2, user.getMotDePasse());
            prstm.setString(3, user.getRole().name());

            prstm.executeUpdate();

        }
    }
}

