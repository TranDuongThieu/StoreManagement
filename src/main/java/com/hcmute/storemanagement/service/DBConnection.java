package com.hcmute.storemanagement.service;

import java.sql.*;

public class DBConnection {

    private final static String serverName = "localhost";
    private final static String dbName = "CUAHANGDIENTU";
    private final static String portNumber = "1433";
    private final static String instance = ""; // MSSQLSERVER LEAVE THIS ONE
    private final static String userID = "sa";
    private final static String password = "1234567890";

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName="
                + dbName + ";user=" + userID + ";password=" + password + ";encrypt=false;";
        return DriverManager.getConnection(url);
    }

    public static void main(String[] args) {
        Connection sqlConnection = null;
        try {
            sqlConnection = getConnection();
            System.out.println("Database connection established successfully.");
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        } finally {
            try {
                if (sqlConnection != null && !sqlConnection.isClosed()) {
                    sqlConnection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error closing the connection: " + e.getMessage());
            }
        }
    }
}
