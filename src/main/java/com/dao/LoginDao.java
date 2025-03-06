package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.model.Role;
import com.model.User;

public class LoginDao {
    public User authenticateUser(String email, String password, String role) {
        User user = null;
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Utilisateur WHERE email = ? AND motDePasse = ? AND role = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
            statement.setString(3, role);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setEmail(resultSet.getString("email"));
                user.setMotDePasse(resultSet.getString("motDePasse"));
                user.setRole(Role.valueOf(resultSet.getString("role")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}