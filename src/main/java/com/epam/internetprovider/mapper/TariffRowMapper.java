package com.epam.internetprovider.mapper;

import com.epam.internetprovider.entity.Tariff;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TariffRowMapper implements RowMapper<Tariff> {
    @Override
    public Tariff map(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong(Tariff.ID);
        String name = resultSet.getString(Tariff.NAME);
        String startDate = resultSet.getString(Tariff.START_DATE);
        String endDate = resultSet.getString(Tariff.END_DATE);
        boolean isPaid = resultSet.getBoolean(Tariff.IS_PAID);
        boolean isDeleted = resultSet.getBoolean(Tariff.IS_DELETED);
        return new Tariff(id, name, startDate, endDate, isPaid, isDeleted);
    }
}
