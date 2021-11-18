package com.example.assignment2martina.controller;

import com.example.assignment2martina.model.Movie;
import com.example.assignment2martina.model.MovieDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class AllMovieController
 */
@WebServlet("/AllMovieController")
public class AllMovieController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllMovieController() {
        super();
        // TODO Auto-generated constructor stub
    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        // Sets the variables to be used
        String title = request.getParameter("title");
        String star = request.getParameter("star");
        String year = request.getParameter("year");
        String email = request.getParameter("email");

        String name = request.getParameter("name");
        // Creates an Array list called allMovies
        ArrayList<Movie> allMovies = null;

        try {
            // Sets allmovies to the DB Movie list
            allMovies = MovieDAO.instance.list();
            request.setAttribute("allMovieList", allMovies);  // sets the variable "allMovieList" to allMovies
            request.getRequestDispatcher("showMovies.jsp").forward(request, response); // sends the user to ShowMovies.jsp page
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("allMovieList", allMovies);
        request.getRequestDispatcher("showMovies.jsp").forward(request, response);
    }

}
