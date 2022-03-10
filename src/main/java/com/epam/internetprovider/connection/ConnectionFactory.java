package com.epam.internetprovider.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
    public ProxyConnection create() throws SQLException, IOException, ClassNotFoundException {
        ConnectorDatabase connectorDatabase = new ConnectorDatabase();
        return (ProxyConnection) connectorDatabase.getConnection();
    }
}
