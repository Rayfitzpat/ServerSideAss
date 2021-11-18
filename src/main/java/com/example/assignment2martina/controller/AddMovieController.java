package com.example.assignment2martina.controller;

import com.example.assignment2martina.model.Movie;
import com.example.assignment2martina.model.MovieDAO;
import com.example.assignment2martina.model.User;
import com.example.assignment2martina.model.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AddMovieController", value = "/AddMovieController")
public class AddMovieController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Setting the variables
        HttpSession session = request.getSession();

        String title = request.getParameter("title");
        String star = request.getParameter("star");
        String year = request.getParameter("year");

        String email = (String) session.getAttribute("email");
        

        
        int count = 0;
        try {
            ArrayList<Movie> movies = MovieDAO.instance.list();
            if (!title.equals("") && !star.equals("") && !year.equals("")) {
                for (int i = 0; i < movies.size(); i++) {
// cycling through the Movie Array, checking if the title and email match and if they do, reload the main page and alert the user that that email is already registered to that movie
                    if (title.equals(movies.get(i).getTitle()) && (email.equals(movies.get(i).getEmail()))) {
                        JOptionPane.showMessageDialog(null, title + " is already registered to this email");
                        request.getRequestDispatcher("main.jsp").forward(request, response);
                        count++;
                    }
                }
// Count will be one if the it matches the email and name so if its != 1 then go ahead and add the new movie to the DB
                if (!(count == 1)) {
//                    movies.add(m1);
                    MovieDAO.instance.save(title, star, year, email);
                    JOptionPane.showMessageDialog(null, "You have added the movie " + title);
                    request.getRequestDispatcher("UserMovieController").forward(request, response);
                } else {
                    System.out.println("Movie addition has gone wrong");
                }
            }
            // Stops empty input fields from being entered
            else {
                JOptionPane.showMessageDialog(null, " input fields cannot be left empty");
                request.getRequestDispatcher("main.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



