package com;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


public class ConnectionBD{

    private final String connectionUrl;
    private final String user;
    private final String password;

    public ConnectionBD() throws IOException {
        Properties properties = new Properties();
        try (InputStream stream = new FileInputStream("database.properties")) {
            properties.load(stream);
            this.connectionUrl = properties.getProperty("connectionUrl");
            this.user = properties.getProperty("user");
            this.password = properties.getProperty("password");
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                connectionUrl, user, password);
    }


//    public static void main(String[] args) {
//
//        // auto-closeable
//        try (Connection connection = ConnectionBD.getConnection()) {
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//        // antes do java 7
//       /* Connection connection = null;
//        try {
//            connection = ConnectionBD.getConnection()
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if(connection != null) {
//                connection.close();
//            }
//        }*/
//
//
//    }



}
