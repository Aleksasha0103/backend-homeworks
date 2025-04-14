package com.itgirls.restapp.service;

import com.itgirls.restapp.config.Config;
import com.itgirls.restapp.entity.User;

import java.sql.*;

public class UserService {
    public void createUser(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        //Statement - обычный sql, уязвим к инъекциям
        //PreparedStatement
        //CallableStatement
        ResultSet resultSet = null;

        //todo validation
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(Config.JDBC_URL, Config.USERNAME, Config.PASSWORD);

            String query = "SELECT * FROM users;";
            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

        } catch (ClassNotFoundException e) {
            //todo
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
            //todo
        }
    }
}

