package com.epam.internetprovider.dao;

import com.epam.internetprovider.entity.Tariff;
import com.epam.internetprovider.exception.DaoException;
import com.epam.internetprovider.mapper.TariffRowMapper;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public class TariffDaoImpl extends AbstractDao<Tariff> implements TariffDao {

    private static final String FIND_ALL_TARIFFS_WITH_PRICES = "select tariff.id, tariff.name, tariff.start_Date," +
            " tariff.end_date, tariff.is_paid, tariff.is_deleted, tariff_price.price from" +
            " tariff join tariff_price on tariff.id = tariff_price.tariff_id";
    private static final String FIND_BY_ID = FIND_ALL_TARIFFS_WITH_PRICES + " where tariff.id = ?";

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
        return executeForSingleResult(FIND_BY_ID, id);
    }

    @Override
    public List<Tariff> getAll() throws DaoException {
        return executeQuery(FIND_ALL_TARIFFS_WITH_PRICES);
    }
}
