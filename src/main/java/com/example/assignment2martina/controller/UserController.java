package com.example.assignment2martina.controller;

import com.example.assignment2martina.model.User;
import com.example.assignment2martina.model.UserDAO;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;


/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<User> users = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
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

		// Setting the variables to be used
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// created a new object of User called u1
		User u1 = new User(name, email, password);

		try {
			// Created an arrayList called users and sets it to the users in the Db by calling the list() method in UserDAO
			ArrayList<User> users = UserDAO.instance.list();
			for (int i =0; i< users.size(); i++) { // cycles through the array
				if (email.equals(users.get(i).getEmail())) {  // checks the email to see if it already exists in the DB
					if (password.equals(users.get(i).getPassword())) { // checks the password against the DB
						// sets Session Storage info for name and email
						HttpSession session = request.getSession();
						session.setAttribute("email", email);
						session.setAttribute("name", name);
						request.getRequestDispatcher("main.jsp").forward(request, response); // logs the user in by sending them to the main.jsp page
					} else { // if Pw doesnt match the email in the Db then user is alerted and page is reloaded
						JOptionPane.showMessageDialog(null, "The email address is valid but your Password is incorrect");
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
				} else {
					System.out.println("email is wrong");
				} // redirects the user to register.jsp if email doesnt match the DB
			}request.getRequestDispatcher("register.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("information could not be retrieved");
		}
	}
}
