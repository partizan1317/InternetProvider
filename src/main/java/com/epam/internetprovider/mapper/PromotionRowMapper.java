package com.epam.internetprovider.mapper;

import com.epam.internetprovider.entity.Promotion;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PromotionRowMapper implements RowMapper<Promotion> {

    @Override
    public Promotion map(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong(Promotion.ID);
        String name = resultSet.getString(Promotion.NAME);
        String startDate = resultSet.getString(Promotion.START_DATE);
        String endDate = resultSet.getString(Promotion.END_DATE);
        BigDecimal discount = resultSet.getBigDecimal(Promotion.DISCOUNT);
        long tariffId = resultSet.getLong(Promotion.TARIFF_ID);
        boolean isDeleted = resultSet.getBoolean(Promotion.IS_DELETED);
        return new Promotion(id, name, startDate, endDate, discount, tariffId, isDeleted);
    }
}
