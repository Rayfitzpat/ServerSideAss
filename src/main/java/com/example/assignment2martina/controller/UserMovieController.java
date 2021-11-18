package com.example.assignment2martina.controller;

import com.example.assignment2martina.model.Movie;
import com.example.assignment2martina.model.MovieDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class UserMovieController
 */
@WebServlet("/UserMovieController")
public class UserMovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserMovieController() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String star = request.getParameter("star");
		String year = request.getParameter("year");
		String email = (String)session.getAttribute("email");

		String name = request.getParameter("name");

		ArrayList<Movie> userMovies = null;
//		Movie movies = new Movie(title,star,year,email);

		try {
//				MovieDAO.save(title,star,year,email);
				userMovies = MovieDAO.instance.selectOne(email);
				request.setAttribute("userMovieList", userMovies);
				request.getRequestDispatcher("showUserMovies.jsp").forward(request, response);
			}
			 catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("userMovieList", userMovies);
		request.getRequestDispatcher("showMovies.jsp").forward(request, response);
	}

}
