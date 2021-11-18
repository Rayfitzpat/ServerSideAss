package com.example.assignment2martina.controller;

import com.example.assignment2martina.model.MovieDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserDeleteMovieController", value = "/UserDeleteMovieController")
public class UserDeleteMovieController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Setting the variables to be used
        HttpSession session = request.getSession();
        String email = (String)session.getAttribute("email"); // retrieved from session storage
        String title = request.getParameter("title");

        try {
            MovieDAO.instance.delete(title,email); // calls the delete() method using the parameters of title and email from above
            request.getRequestDispatcher("UserMovieController").forward(request, response); // opens the UserMovieController page
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    }
