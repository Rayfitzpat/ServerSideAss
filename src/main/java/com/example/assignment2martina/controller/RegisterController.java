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
        // Sets the variables to be used
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Creates an object of User called u1
        User u1 = new User(name, email, password);
        int count = 0;
        try {
            // Creates an ArrayList called users and sets it to the list of users from the DB using the list() method
            ArrayList<User> users = UserDAO.instance.list();
            for (int i = 0; i < users.size(); i++) {
                if (email.equals(users.get(i).getEmail())) { // If the email is already in the DB, tell the user and reload the page
                    JOptionPane.showMessageDialog(null, "This Email is already registered, please Login");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } else {
                    count++;
                }
            }
            // If the count is the same size as the Array list it means that the user doesnt exist in the DB and one is created and added
                if( count == users.size()){
                    users.add(u1);
                    UserDAO.instance.save(u1);
                    JOptionPane.showMessageDialog(null, "You have successfully registered, please log in");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                else{
                    System.out.println("Registration has gone wrong");
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
