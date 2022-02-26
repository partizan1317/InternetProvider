package com.epam.internetprovider.dao;

import com.epam.internetprovider.connection.ConnectorDatabase;
import com.epam.internetprovider.entity.User;
import com.epam.internetprovider.exception.DaoException;

import java.io.IOException;
import java.sql.*;
import java.util.Optional;

public class SimpleUserDao implements UserDao {

    public Optional<User> findUserByLoginAndPassword(final String login, final String password) throws DaoException {
        try {
            ConnectorDatabase connectorDatabase = new ConnectorDatabase();
            Connection connection = connectorDatabase.getConnection();
            try (PreparedStatement statement = connection.prepareStatement("SELECT ID, LOGIN FROM USER WHERE" +
                    " LOGIN = ? AND PASSWORD = ?")) {
                statement.setString(1, login);
                statement.setString(2, password);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return Optional.of(new User(resultSet.getLong("ID"), resultSet.getString("LOGIN")));
                    }
                }
            }
            return Optional.empty();
            } catch (SQLException | ClassNotFoundException | IOException e) {
                throw new DaoException(e);
            }
        }
    }
