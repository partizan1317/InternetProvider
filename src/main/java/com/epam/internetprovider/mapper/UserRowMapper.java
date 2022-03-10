package com.epam.internetprovider.mapper;

import com.epam.internetprovider.entity.User;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User>{
    @Override
    public User map(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String surname = resultSet.getString("surname");
        String login = resultSet.getString("login");
        boolean isAdmin = resultSet.getBoolean("is_Admin");
        BigDecimal amount = resultSet.getBigDecimal("amount");
        boolean isBlocked = resultSet.getBoolean("is_Blocked");
        return new User(id, name, surname, login, amount, isAdmin, isBlocked);
    }
}
