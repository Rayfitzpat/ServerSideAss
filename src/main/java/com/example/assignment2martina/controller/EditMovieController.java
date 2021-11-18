package com.example.assignment2martina.controller;

import com.example.assignment2martina.model.Movie;
import com.example.assignment2martina.model.MovieDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "EditMovieController", value = "/EditMovieController")
public class EditMovieController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Sets the variables to be used
        HttpSession session = request.getSession();

        String title = request.getParameter("title");
        String email = (String)session.getAttribute("email"); // email comes from session storage

        try {
            Movie m = MovieDAO.instance.getMovieInfoForUpdate(title,email); // Calls the method getMovieInfoForUpdate, passes 2 parameters and sets the return value to Movie m
            request.setAttribute("movieToEdit", m); // Sets m to the variable "movieToEdit"
            request.getRequestDispatcher("EditMovie.jsp").forward(request, response); // Sends the user to the page EditMovie.jsp
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
