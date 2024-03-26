/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcmute.storemanagement.DAO;

import java.sql.*;

/**
 *
 * @author WIN 10
 */
public class DBConnection {

    private final static String serverName = "localhost";
    private final static String dbName = "CUAHANGDIENTU";
    private final static String portNumber = "1433";
    private final static String instance = "";// MSSQLSERVER LEAVE THIS ONE
    private final static String userID = "sa";
    private final static String password = "1234567890";

    
    public static java.sql.Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" 
            + dbName + ";user=" + userID + ";password=" + password + ";encrypt=false;";
        java.sql.Connection conn = DriverManager.getConnection(url);
        return conn;
    }

}
