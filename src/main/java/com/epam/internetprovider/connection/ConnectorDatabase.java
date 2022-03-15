package com.epam.internetprovider.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectorDatabase {

    private static final String DATABASE_CONNECTION_PROPERTIES_FILE = "databaseConnection.properties";
    private static final String DATABASE_CONNECTION_URL_PROPERTY = "db.url";
    private static final String DATABASE_DRIVER_CLASS_PROPERTY = "db.driver";
    private static final String DATABASE_USER_PROPERTY = "db.user";
    private static final String DATABASE_PASSWORD_PROPERTY = "db.password";

    public Connection getConnection() throws SQLException, ClassNotFoundException, IOException {
        Properties properties = new Properties();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(DATABASE_CONNECTION_PROPERTIES_FILE);
        properties.load(inputStream);
        String databaseDriverClass = properties.getProperty(DATABASE_DRIVER_CLASS_PROPERTY);
        String databaseConnectionUrl = properties.getProperty(DATABASE_CONNECTION_URL_PROPERTY);
        String databaseUser = properties.getProperty(DATABASE_USER_PROPERTY);
        String databasePassword = properties.getProperty(DATABASE_PASSWORD_PROPERTY);
        Class.forName(databaseDriverClass);
        return DriverManager.getConnection(databaseConnectionUrl, databaseUser, databasePassword);
    }
}
