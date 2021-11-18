package com.example.assignment2martina.controller;

import com.example.assignment2martina.model.Movie;
import com.example.assignment2martina.model.MovieDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateMovieController", value = "/UpdateMovieController")
public class UpdateMovieController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Setting the variables to be used
        HttpSession session = request.getSession();

        String title = request.getParameter("title");
        String email = (String)session.getAttribute("email");

        String star = request.getParameter("star");
        String year = request.getParameter("year");

        try {
            MovieDAO.instance.update(title, star, year, email); // calls the update() method from MovieDAO and passes the parameters from the variables created above
            request.getRequestDispatcher("UserMovieController").forward(request, response); // opens userMovieController
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    }
