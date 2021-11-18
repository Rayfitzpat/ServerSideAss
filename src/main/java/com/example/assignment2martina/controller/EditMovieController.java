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
        // TODO Auto-generated method stub
        HttpSession session = request.getSession();

        String title = request.getParameter("title");
        String email = (String)session.getAttribute("email");

//        String star = request.getParameter("star");
//        String year = request.getParameter("year");


        System.out.println(title);
        System.out.println(email);
//        ArrayList<Movie> userMovies = null;
        try {
            Movie m = MovieDAO.instance.getMovieInfoForUpdate(title,email);
            request.setAttribute("movieToEdit", m);
            request.getRequestDispatcher("EditMovie.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    }
