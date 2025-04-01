package gui;

import database.BookingDAO;
import models.Booking;
import models.Movie;
import models.User;

import javax.swing.*;

public class BookingFrame extends JFrame {
    private Movie movie;
    private JTextField seatField;
    private User currentUser;

    public BookingFrame(Movie movie, User currentUser) {
    	this.currentUser = currentUser;
        this.movie = movie;

        setTitle("Book Tickets for " + movie.getTitle());
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel movieLabel = new JLabel("Movie: " + movie.getTitle());
        movieLabel.setBounds(50, 50, 300, 30);
        add(movieLabel);

        JLabel seatLabel = new JLabel("Number of Seats:");
        seatLabel.setBounds(50, 100, 150, 30);
        add(seatLabel);

        seatField = new JTextField();
        seatField.setBounds(180, 100, 100, 30);
        add(seatField);

        JButton bookButton = new JButton("Book Now");
        bookButton.setBounds(130, 160, 120, 40);
        add(bookButton);

        bookButton.addActionListener(e -> bookTicket());

        setVisible(true);
    }

    private void bookTicket() {
        try {
            int seats = Integer.parseInt(seatField.getText());
            Booking booking = new Booking(0, currentUser.getUserId(), movie.getMovieId(), seats);
            boolean success = BookingDAO.bookMovie(booking);

            if (success) {
                JOptionPane.showMessageDialog(this, "🎉 Booking Confirmed for " + seats + " seats!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "❌ Booking Failed. Try Again!");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "⚠️ Enter a valid number of seats!");
        }
    }
}
