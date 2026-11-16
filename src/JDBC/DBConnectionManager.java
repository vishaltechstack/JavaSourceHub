package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {

    // JDBC URL Format: jdbc:<vendor>://<host>:<port>/<database_name>
    private static final String URL = "jdbc:mysql://localhost:3306/core_java_db";
    private static final String USER = "root";
    private static final String PASSWORD = "mysql0728"; // Replace with your local DB password

    // Private constructor prevents instantiation of this utility class
    private DBConnectionManager() {}

    /**
     * Opens and returns a live Connection to the database.
     * Modern JDBC 4.0+ automatically loads the driver class from the classpath.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}