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
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String title = request.getParameter("title");
        String star = request.getParameter("star");
        String year = request.getParameter("year");
        String email = request.getParameter("email");

        String name = request.getParameter("name");

        ArrayList<Movie> allMovies = null;
//		Movie movies = new Movie(title,star,year,email);

        try {
//				MovieDAO.save(title,star,year,email);
            allMovies = MovieDAO.instance.list();
            request.setAttribute("allMovieList", allMovies);
            request.getRequestDispatcher("showMovies.jsp").forward(request, response);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("allMovieList", allMovies);
        request.getRequestDispatcher("showMovies.jsp").forward(request, response);
    }

}
