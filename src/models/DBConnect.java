package models;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

    private static final String URL =
        "jdbc:mysql://www.papademas.net:3307/510fp?autoReconnect=true&useSSL=false";
    private static final String USER = "fp510";
    private static final String PASSWORD = "510";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
