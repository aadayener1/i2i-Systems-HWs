package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class igniteConnector
{
    private static String jdbcUrl = "jdbc:ignite:thin://127.0.0.1/";
    private static String username = "adayener@gmail.com";
    private static String password = "Arda.6372";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection (jdbcUrl, username, password);
    }
}
