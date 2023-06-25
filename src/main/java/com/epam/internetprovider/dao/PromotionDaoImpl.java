package com.epam.internetprovider.dao;

import com.epam.internetprovider.entity.Promotion;
import com.epam.internetprovider.exception.DaoException;
import com.epam.internetprovider.mapper.PromotionRowMapper;
import com.epam.internetprovider.mapper.RowMapper;

import java.sql.Connection;
import java.util.Map;
import java.util.Optional;

public class PromotionDaoImpl extends AbstractDao<Promotion> implements PromotionDao {

    private static final String FIND_BY_ID = "select * from promotion where id = ?";

    protected PromotionDaoImpl(Connection connection) {
        super(connection, new PromotionRowMapper(), Promotion.TABLE);
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
        return executeForSingleResult(FIND_BY_ID, id);
    }
}
