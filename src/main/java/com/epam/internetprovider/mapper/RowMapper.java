package com.epam.internetprovider.mapper;

import com.epam.internetprovider.entity.Identifiable;
import com.epam.internetprovider.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T extends Identifiable> {

    T map(ResultSet resultSet) throws SQLException;

    static RowMapper<? extends Identifiable> create(String table) {
        switch (table) {
            case User.TABLE:
                return new UserRowMapper();
            default:
                throw new IllegalArgumentException("Unknown table = " + table);
        }
    }
}
