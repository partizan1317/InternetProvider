package com.epam.internetprovider.dao;

import com.epam.internetprovider.connection.ConnectionPool;
import com.epam.internetprovider.connection.ProxyConnection;
import com.epam.internetprovider.exception.DaoException;

import java.sql.Connection;
import java.sql.SQLException;

public class DaoHelper implements AutoCloseable {

    private final ProxyConnection connection;

    public DaoHelper(ConnectionPool pool){
        this.connection = pool.getConnection();
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }

    public void startTransaction() throws DaoException {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public void endTransaction() throws DaoException {
        try {
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
