package com.example.assignment2martina.controller;

import com.example.assignment2martina.model.Movie;
import com.example.assignment2martina.model.MovieDAO;
import com.example.assignment2martina.model.User;
import com.example.assignment2martina.model.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AllUserController", value = "/AllUserController")
public class AllUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // TODO Auto-generated method stub
            String name = request.getParameter("name");
            String star = request.getParameter("email");


            ArrayList<User> allUsers = null;
//		Movie movies = new Movie(title,star,year,email);

            try {
//				MovieDAO.save(title,star,year,email);
                allUsers = UserDAO.instance.list();
                request.setAttribute("allUserList", allUsers);
                request.getRequestDispatcher("AllUsers.jsp").forward(request, response);
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

