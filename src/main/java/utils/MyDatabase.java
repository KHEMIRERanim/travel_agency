package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDatabase {
    private final String URL = "jdbc:mysql://localhost:3306/travel_agency";
    private final String USERNAME = "root";
    private final String PASSWORD = "";
    private Connection cnx;
    private static MyDatabase instance;

    private MyDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnx = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected to database successfully");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Database connection failed:");
            e.printStackTrace();
        }
    }

    public static MyDatabase getInstance() {
        if (instance == null) {
            synchronized (MyDatabase.class) {
                if (instance == null) {
                    instance = new MyDatabase();
                }
            }
        }
        return instance;
    }

    public Connection getCnx() {
        try {
            if (cnx == null || cnx.isClosed()) {
                cnx = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }
        } catch (SQLException e) {
            System.err.println("Connection error:");
            e.printStackTrace();
        }
        return cnx;
    }
}