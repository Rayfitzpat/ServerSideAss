package com.example.assignment2martina.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public enum UserDAO {
	instance;

	//CRUD
	//Create - Insert - save
	//Read - Select - list
	//Update - Update - update
	//Delete - Delete - remove

	// Creates the connection to the DB
	public Connection getConnection() throws Exception {
			Class.forName("org.hsqldb.jdbcDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:hsqldb:hsql://localhost/oneDB", "sa", "");
			return con;
		}

	// Method selectOne() that returns an ArrayList of type User
	public User selectOne(String email) throws Exception {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM USER where email ='" + email +"'");
		while(rs.next()) {
		// Adds the matching User from the SQL Query to User u and returns u
			if(rs.getString("email").equals(email)) {
				User u = new User(rs.getString("name"),rs.getString("email"), rs.getString("password"));
				return u;
			}
		}
	return null;
	}

	// Method save() that takes in User u and that users info to the SQL query which creates a new User in the DB
	public void save(User u) throws Exception{
		
		Connection conn = getConnection();
		PreparedStatement psmt = conn.prepareStatement("INSERT INTO USER (name,email,password) VALUES (?,?,?)");

		psmt.setString(1,  u.getName());
		psmt.setString(2, u.getEmail());
		psmt.setString(3,  u.getPassword());
		psmt.executeUpdate();
		psmt.close();
		conn.close();
	}

	// Method list(). with return of ArrayList of User
// Creates an Arraylist called Users and then adds all the users returned from the SQL query to that ArrayList.
	public ArrayList<User> list() throws Exception{
		ArrayList<User> Users = new ArrayList();
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM USER");
		while (rs.next()) {
			User u = new User(rs.getString("NAME"), rs.getString("EMAIL"), rs.getString("PASSWORD"));
			Users.add(u);
		}
		return Users;
	}
}
