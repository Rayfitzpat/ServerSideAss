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

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User u1 = new User(name, email, password);
		System.out.println("Before Try");

		try {
			System.out.println("Start Try");
			ArrayList<User> users = UserDAO.instance.list();
			System.out.println("Start Array");
			for (int i =0; i< users.size(); i++) {
				System.out.println("Start if");
				System.out.println("users email: " + email);
				System.out.println(users.get(i).getEmail());
				if (email.equals(users.get(i).getEmail())) {
					System.out.println("Get Email");
					System.out.println("email success");
					if (password.equals(users.get(i).getPassword())) {
						System.out.println("pw success");
						HttpSession session = request.getSession();
						session.setAttribute("email", email);
						session.setAttribute("name", name);


						request.getRequestDispatcher("main.jsp").forward(request, response);

					} else {
						System.out.println("pw is wrong");
//						request.getParameter("#message").equals("Your Password is incorrect");
						JOptionPane.showMessageDialog(null, "The email address is valid but your Password is incorrect");
						request.getRequestDispatcher("index.jsp").forward(request, response);

//						request.getParameter("message").equals("Your Password is incorrect");
//						request.getRequestDispatcher("main.jsp").forward(request, response);
					}
				} else {
					System.out.println("email is wrong");
//					request.getParameter("message").equals("email is wrong");
//
				}
			}request.getRequestDispatcher("register.jsp").forward(request, response);

			//UserDAO.instance.save(u1);
			//String check = "mcurran@ait.ie";
			//User user = UserDAO.instance.selectOne(check);
			//System.out.println(u1.getName());
//			request.setAttribute("userList", users);
//			request.getRequestDispatcher("showUser.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("information could not be retrieved");
			// TODO Auto-generated catch block
			//e.printStackTrace();
//			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		
		
	}

}
