package com.epam.internetprovider.mapper;

import com.epam.internetprovider.entity.Identifiable;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T extends Identifiable> {

    T map(ResultSet resultSet) throws SQLException;

    static RowMapper<? extends Identifiable> create(String table) {
        switch (table) {
            default:
                throw new IllegalArgumentException("Unknown table = " + table);
        }
    }
}
