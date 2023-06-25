package com.epam.internetprovider.dao;

import com.epam.internetprovider.connection.ConnectionPool;

import java.io.IOException;
import java.sql.SQLException;

public class DaoHelperFactory {
    public DaoHelper create() throws SQLException, IOException, ClassNotFoundException {
        return new DaoHelper(ConnectionPool.getInstance());
    }
}
