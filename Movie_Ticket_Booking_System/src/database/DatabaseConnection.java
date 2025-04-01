package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        // ALWAYS create new connection
        String url = "jdbc:mysql://localhost:3306/movie_booking";
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }
}

