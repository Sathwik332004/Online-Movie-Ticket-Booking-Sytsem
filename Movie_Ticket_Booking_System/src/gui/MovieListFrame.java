package gui;

import database.MovieDAO;
import models.Movie;
import models.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MovieListFrame extends JFrame {
    private JList<String> movieJList;
    private DefaultListModel<String> listModel;
    private ArrayList<Movie> movieList;
    private User currentUser;

    public MovieListFrame(User currentUser) {
    	this.currentUser = currentUser;
        setTitle("Movie Selection");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        movieJList = new JList<>(listModel);
        
        JScrollPane scrollPane = new JScrollPane(movieJList);
        add(scrollPane, BorderLayout.CENTER);

        JButton bookButton = new JButton("Book Selected Movie");
        add(bookButton, BorderLayout.SOUTH);

        loadMovies();

        bookButton.addActionListener(e -> {
            int selectedIndex = movieJList.getSelectedIndex();
            if (selectedIndex != -1) {
                Movie selectedMovie = movieList.get(selectedIndex);
                new BookingFrame(selectedMovie,currentUser);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a movie to book!");
            }
        });

        setVisible(true);
    }

    private void loadMovies() {
        movieList = MovieDAO.getAllMovies();
        
        if (movieList == null || movieList.isEmpty()) {
            System.out.println("⚠️ No movies retrieved from database!");
            JOptionPane.showMessageDialog(this, "No movies available!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (Movie movie : movieList) {
            listModel.addElement(movie.getTitle() + " - " + movie.getGenre() + " - $" + movie.getPrice());
        }
    }
}
