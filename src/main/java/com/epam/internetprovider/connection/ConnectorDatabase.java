package com.epam.internetprovider.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class ConnectorDatabase {

    public Connection getConnection() throws SQLException, ClassNotFoundException, IOException {
//        Properties properties = new Properties();
//        FileInputStream fileInputStream = new FileInputStream("src/main/resources/databaseConnection.properties");
//        properties.load(fileInputStream);
//        fileInputStream.close();
//        String driver = properties.getProperty("db.driver");
//        if (driver != null) {
//            Class.forName(driver);
//        }
//        String url = properties.getProperty("db.url");
//        String user = properties.getProperty("db.user");
//        String password = properties.getProperty("db.password");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("databaseConnection");
        String url = resourceBundle.getString("db.url");
        String user = resourceBundle.getString("db.user");
        String password = resourceBundle.getString("db.password");
        String driver = resourceBundle.getString("db.driver");
        Class.forName(driver);
        return DriverManager.getConnection(url, user, password);
    }
}
