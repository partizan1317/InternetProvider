package com.epam.internetprovider.mapper;

import com.epam.internetprovider.entity.Promotion;
import com.epam.internetprovider.entity.Tariff;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class PromotionRowMapper implements RowMapper<Promotion> {

    @Override
    public Promotion map(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(Promotion.ID);
        String name = resultSet.getString(Promotion.NAME);
        Date startDate = resultSet.getDate(Promotion.START_DATE);
        Date endDate = resultSet.getDate(Promotion.END_DATE);
        BigDecimal discount = resultSet.getBigDecimal(Promotion.DISCOUNT);
        Long tariffId = resultSet.getLong(Promotion.TARIFF_ID);
        Tariff tariff = Tariff.byId(tariffId);
        Boolean isDeleted = resultSet.getBoolean(Promotion.IS_DELETED);
        return new Promotion(id, name, startDate, endDate, discount, tariff, isDeleted);
    }
}
