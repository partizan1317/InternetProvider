package com.epam.internetprovider.dao;

import com.epam.internetprovider.entity.Identifiable;
import com.epam.internetprovider.entity.User;
import com.epam.internetprovider.exception.DaoException;
import com.epam.internetprovider.mapper.RowMapper;


import java.io.StringBufferInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public abstract class AbstractDao <T extends Identifiable> implements Dao<T>{

    private final Connection connection;
    private final RowMapper<T> rowMapper;
    private final String table;

    protected AbstractDao(Connection connection, RowMapper<T> rowMapper,String table) {
        this.connection = connection;
        this.rowMapper = rowMapper;
        this.table = table;
    }

    protected List<T> executeQuery(String query, Object... params) throws DaoException {
        try(PreparedStatement statement = createStatement(query, params);
            ResultSet resultSet = statement.executeQuery()) {
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

    @Override
    public Optional<T> getById(Long id) throws DaoException {
        String query = "SELECT * FROM " + table + " WHERE id=?;";
        return executeForSingleResult(query, id);
    }

    public List<T> getAll() throws DaoException {
        RowMapper<T> mapper = (RowMapper<T>) RowMapper.create(table);
        return executeQuery("select * from " + table, mapper);
    }

    @Override
    public void removeById(Long id) throws SQLException {
        PreparedStatement statement = createStatement("DELETE FROM " + table + " WHERE id=?;", id);
        statement.executeUpdate();
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
    public void save(T item) throws DaoException {
        Map<String, Object> fields = getFields(item);
        String query = (item.getId() == null) ? generateInsertQuery(fields.keySet()) : generateUpdateQuery(fields.keySet());
        executeUpdate(query, fields);
    }

    public void executeUpdate(String query, Object... params) throws DaoException {
        try(PreparedStatement statement = createStatement(query, params)){
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public void executeUpdate(String query, Map<String,Object> values) throws DaoException {
        try(PreparedStatement statement = generatePreparedStatementFromValuesMap(query, values)){
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private String generateInsertQuery(Collection<String> fields) {
        return String.format("INSERT INTO %s(%s);",
                table,
                String.join(", ", fields),
                String.join(", ", Collections.nCopies(fields.size(), "?"))
        );
    }

    private String generateUpdateQuery(Collection<String> fields) {
        String updatePrefix = "UPDATE " + User.TABLE + " SET ";
        StringJoiner updateQuery = new StringJoiner(", ", updatePrefix, ";" );
        for (String field : fields) {
            updateQuery.add(field + " = ?");
        }
        return updateQuery.toString();
    }

    private PreparedStatement generatePreparedStatementFromValuesMap(String query, Map<String, Object> valuesMap) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        int preparedStatementIndex = 1;
        for (String key : valuesMap.keySet()) {
            preparedStatement.setObject(preparedStatementIndex++, valuesMap.get(key));
        }
        return preparedStatement;
    }

    protected abstract Map<String, Object> getFields(T item);


    protected abstract String getTableName();
}
