package com.epam.internetprovider.mapper;

import com.epam.internetprovider.entity.User;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User>{
    @Override
    public User map(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong(User.ID);
        String name = resultSet.getString(User.NAME);
        String surname = resultSet.getString(User.SURNAME);
        String login = resultSet.getString(User.LOGIN);
        boolean isAdmin = resultSet.getBoolean(User.IS_ADMIN);
        BigDecimal amount = resultSet.getBigDecimal(User.AMOUNT);
        boolean isBlocked = resultSet.getBoolean(User.IS_BLOCKED);
        long tariff_id = resultSet.getLong(User.TARIFF_ID);
        return new User(id, name, surname, login, amount, isAdmin, isBlocked, tariff_id);
    }
}
