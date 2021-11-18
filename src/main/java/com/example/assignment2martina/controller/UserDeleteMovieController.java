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
        // TODO Auto-generated method stub
        HttpSession session = request.getSession();
        String email = (String)session.getAttribute("email");
        String title = request.getParameter("title");



        System.out.println(email);
        System.out.println(title);

        try {
            MovieDAO.instance.delete(title,email);
            request.getRequestDispatcher("UserMovieController").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    }
