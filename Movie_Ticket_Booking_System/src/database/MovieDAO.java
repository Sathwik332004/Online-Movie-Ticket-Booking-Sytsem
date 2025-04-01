package database;

import models.Movie;

import java.sql.*;
import java.util.ArrayList;

public class MovieDAO {

    /**
     * Retrieves all movies from the database.
     *
     * @return An ArrayList of Movie objects representing all movies in the database.
     */
    public static ArrayList<Movie> getAllMovies() {
        ArrayList<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM movies";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                movies.add(new Movie(
                        rs.getInt("movie_id"),
                        rs.getString("title"),
                        rs.getString("genre"),
                        rs.getDouble("price") // Correct column name for price
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }
}
