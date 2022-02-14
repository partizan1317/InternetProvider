package com.epam.internetprovider.dao;

import com.epam.internetprovider.connection.ConnectionPool;

public class DaoHelperFactory {
    public DaoHelper create() {
        return new DaoHelper(ConnectionPool.getInstance());
    }
}
