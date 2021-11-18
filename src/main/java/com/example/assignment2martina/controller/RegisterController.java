package com.example.assignment2martina.controller;

import com.example.assignment2martina.model.MovieDAO;
import com.example.assignment2martina.model.User;
import com.example.assignment2martina.model.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "RegisterController", value = "/RegisterController")
public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User u1 = new User(name, email, password);
        int count = 0;
        try {
            ArrayList<User> users = UserDAO.instance.list();
            for (int i = 0; i < users.size(); i++) {
                if (email.equals(users.get(i).getEmail())) {
                    JOptionPane.showMessageDialog(null, "This Email is already registered, please Login");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } else {
                    count++;
                    System.out.println(count);
                }
            }
                if( count == users.size()){
                    users.add(u1);
                    UserDAO.instance.save(u1);
                    JOptionPane.showMessageDialog(null, "You have successfully registered, please log in");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                else{
                    System.out.println("Registration gone wrong");
                }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
