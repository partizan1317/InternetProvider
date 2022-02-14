package com.epam.internetprovider.dao;

import com.epam.internetprovider.entity.User;
import com.epam.internetprovider.exception.DaoException;

import java.sql.*;
import java.util.Optional;

public class SimpleUserDao implements UserDao {

    public Optional<User> findUserByLoginAndPassword(final String login, final String password) throws DaoException {
        try {
            Class.forName("org.h2.Driver");
            Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost:9092/~/users","sa","");
            try (PreparedStatement statement = connection.prepareStatement("SELECT ID, LOGIN FROM USER WHERE" +
                    "LOGIN = ? AND PASSWORD = HASH('SHA256', STRINGTOUTF8(?),1000)")) {
                statement.setString(1, login);
                statement.setString(2, password);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return Optional.of(new User(resultSet.getLong("ID"), resultSet.getString("LOGIN")));
                    }
                }
            }
            return Optional.empty();
            } catch (SQLException | ClassNotFoundException e) {
                throw new DaoException(e);
            }
        }
    }

}
