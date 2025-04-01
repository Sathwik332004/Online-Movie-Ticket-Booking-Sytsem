package models;

public class Movie {
    private int movieId;
    private String title;
    private String genre;
    private double price;

    public Movie(int movieId, String title, String genre, double price) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.price = price;
    }

    // Getters
    public int getMovieId() { return movieId; }
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public double getPrice() { return price; }
}
