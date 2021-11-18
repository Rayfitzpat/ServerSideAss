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

        HttpSession session = request.getSession();

        String title = request.getParameter("title");
        String star = request.getParameter("star");
        String year = request.getParameter("year");

        String email = (String) session.getAttribute("email");

//        Movie m1 = new Movie(title, star, year, email);

        int count = 0;
        try {
            ArrayList<Movie> movies = MovieDAO.instance.list();
            for (int i = 0; i < movies.size(); i++) {
                if (!title.equals("") && !star.equals("") && !year.equals("")) {
                    if (title.equals(movies.get(i).getTitle())) {
                        if (email.equals(movies.get(i).getEmail())) {
                            JOptionPane.showMessageDialog(null, title + " is already registered to this email");
                            request.getRequestDispatcher("main.jsp").forward(request, response);
                        } else {
                            count++;
                            System.out.println(count);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, " input fields cannot be left empty");
                    request.getRequestDispatcher("main.jsp").forward(request, response);
                }
            }
            System.out.println("Count: " + count);
            System.out.println("Array Size: " +movies.size());
                if (count == 0) {
//                    movies.add(m1);
                    MovieDAO.instance.save(title, star, year, email);
                    JOptionPane.showMessageDialog(null, "You have added the movie " + title);
                    request.getRequestDispatcher("UserMovieController").forward(request, response);
                } else {
                    System.out.println("Movie addition has gone wrong");
                }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}





//        try {
//            MovieDAO.instance.save(m1);
//            request.getRequestDispatcher("EditMovie.jsp").forward(request, response);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }



