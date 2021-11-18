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
            // Sets the variables to be used
            String name = request.getParameter("name");
            String star = request.getParameter("email");

            // Creates an Array list called allUsers
            ArrayList<User> allUsers = null;

            try {
                // Sets allUsers to the DB User list
                allUsers = UserDAO.instance.list();
                request.setAttribute("allUserList", allUsers); // sets the variable "allUserList" to allUsers
                request.getRequestDispatcher("AllUsers.jsp").forward(request, response);  // sends the user to AllUsers.jsp page
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

