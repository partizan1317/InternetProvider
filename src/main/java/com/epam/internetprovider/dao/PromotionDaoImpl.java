package com.epam.internetprovider.dao;

import com.epam.internetprovider.entity.Promotion;
import com.epam.internetprovider.exception.DaoException;
import com.epam.internetprovider.mapper.RowMapper;

import java.sql.Connection;
import java.util.Map;
import java.util.Optional;

public class PromotionDaoImpl extends AbstractDao<Promotion> implements PromotionDao {
    protected PromotionDaoImpl(Connection connection, RowMapper<Promotion> rowMapper, String table) {
        super(connection, rowMapper, table);
    }

    @Override
    protected Map<String, Object> getFields(Promotion item) {
        return null;
    }

    @Override
    protected String getTableName() {
        return null;
    }

    @Override
    public Optional<Promotion> getById(Long id) throws DaoException {
        return Optional.empty();
    }
}
