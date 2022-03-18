package com.epam.internetprovider.mapper;

import com.epam.internetprovider.entity.Tariff;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TariffRowMapper implements RowMapper<Tariff> {
    @Override
    public Tariff map(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(Tariff.ID);
        String name = resultSet.getString(Tariff.NAME);
        Date startDate = resultSet.getDate(Tariff.START_DATE);
        Date endDate = resultSet.getDate(Tariff.END_DATE);
        Boolean isPaid = resultSet.getBoolean(Tariff.IS_PAID);
        Boolean isDeleted = resultSet.getBoolean(Tariff.IS_DELETED);
        BigDecimal price = resultSet.getBigDecimal(Tariff.PRICE);
        return new Tariff(id, name, startDate, endDate, isPaid, isDeleted, price);
    }
}
