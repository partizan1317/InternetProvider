package com.epam.internetprovider.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionFactory {

    public ProxyConnection create(ConnectionPool pool) throws SQLException, IOException, ClassNotFoundException {
        List<ProxyConnection> proxyConnections = create(pool,1);
        return proxyConnections.get(0);
    }

    public List<ProxyConnection> create(ConnectionPool pool, int count) throws SQLException, IOException, ClassNotFoundException {
        List<ProxyConnection> proxyConnections = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            proxyConnections.add(new ProxyConnection(pool, createConnection()));
        }
        return proxyConnections;
    }

    private Connection createConnection() throws SQLException, IOException, ClassNotFoundException {
        ConnectorDatabase connectorDatabase = new ConnectorDatabase();
        return connectorDatabase.getConnection();
    }
}
