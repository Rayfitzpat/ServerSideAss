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
        HttpSession session = request.getSession();

        String title = request.getParameter("title");
        String email = (String)session.getAttribute("email");

        String star = request.getParameter("star");
        String year = request.getParameter("year");


        System.out.println(title);
        System.out.println(email);
        System.out.println(star);
        System.out.println(year);

//        ArrayList<Movie> userMovies = null;
        try {
            MovieDAO.instance.update(title, star, year, email);
//            request.setAttribute("movieToEdit", m);
            request.getRequestDispatcher("UserMovieController").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    }
