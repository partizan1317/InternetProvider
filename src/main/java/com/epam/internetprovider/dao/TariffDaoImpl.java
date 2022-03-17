package com.epam.internetprovider.dao;

import com.epam.internetprovider.entity.Tariff;
import com.epam.internetprovider.exception.DaoException;
import com.epam.internetprovider.mapper.TariffRowMapper;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TariffDaoImpl extends AbstractDao<Tariff> implements TariffDao {
    protected TariffDaoImpl(Connection connection) {
        super(connection, new TariffRowMapper(), Tariff.TABLE);
    }

    @Override
    protected Map<String, Object> getFields(Tariff item) {
        return null;
    }

    @Override
    protected String getTableName() {
        return null;
    }

    @Override
    public Optional<Tariff> getById(Long id) throws DaoException {
        return super.getById(id);
    }

    @Override
    public List<Tariff> getAll() throws DaoException {
        return super.getAll();
    }
}
