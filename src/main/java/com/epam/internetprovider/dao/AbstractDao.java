package com.epam.internetprovider.dao;

import com.epam.internetprovider.entity.Identifiable;
import com.epam.internetprovider.exception.DaoException;
import com.epam.internetprovider.mapper.RowMapper;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class AbstractDao <T extends Identifiable> implements Dao<T>{

    private final Connection connection;
    private final RowMapper<T> rowMapper;

    protected AbstractDao(Connection connection, RowMapper<T> rowMapper) {
        this.connection = connection;
        this.rowMapper = rowMapper;
    }

    protected List<T> executeQuery(String query, Object... params) throws DaoException {
        try(PreparedStatement statement = createStatement(query, params);
            ResultSet resultSet = statement.executeQuery(query)) {
            List<T> entities = new ArrayList<>();
            while(resultSet.next()) {
                T entity = rowMapper.map(resultSet);
                entities.add(entity);
            }
            return entities;
        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    private PreparedStatement createStatement(String query, Object... params) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        for(int i = 1; i <= params.length; i++) {
            statement.setObject(i, params[i-1]);
        }
        return statement;
    }

    public List<T> getAll() throws DaoException {
        String table = getTableName();
        RowMapper<T> mapper = (RowMapper<T>) RowMapper.create(table);
        return executeQuery("select * from " + table, mapper);
    }

    protected Optional<T> executeForSingleResult(String query, Object... params) throws DaoException {
        List<T> items = executeQuery(query,params);
        if (items.size() == 1) {
            return Optional.of(items.get(0));
        } else if (items.size() > 1) {
            throw new IllegalArgumentException("More than one record found");
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void save(T item) {
        Map<String, Object> fields = getFields(item);
        if (item.getId() == null) {
            //insert
        } else {
            //update
        }
    }

    public boolean executeUpdate(String query, Object... params) throws DaoException {
        try(PreparedStatement statement = createStatement(query, params)){
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private String generateInsertQuery(Map<String, Object> fields) {
        throw new UnsupportedOperationException();
    }

    private String generateUpdateQuery(Map<String, Object> fields) {
        throw new UnsupportedOperationException();
    }

    protected abstract Map<String, Object> getFields(T item);

    protected abstract String getTableName();
}
