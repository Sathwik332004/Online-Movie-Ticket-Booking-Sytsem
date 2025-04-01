package models;

public class Booking {
    private int bookingId;
    private int userId;
    private int movieId;
    private int seats;

    public Booking(int bookingId, int userId, int movieId, int seats) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.movieId = movieId;
        this.seats = seats;
    }

    // Getters
    public int getBookingId() { return bookingId; }
    public int getUserId() { return userId; }
    public int getMovieId() { return movieId; }
    public int getSeats() { return seats; }
}
