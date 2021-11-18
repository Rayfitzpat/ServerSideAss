package com.example.assignment2martina.model;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;


public enum MovieDAO {
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

	// Method selectOne() that returns an ArrayList of type Movie
	public ArrayList<Movie> selectOne(String email) throws Exception {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM movies  where email ='" + email + "'"); // SQL Query
	// Creates an arrayList called movies
		ArrayList<Movie> movies = new ArrayList<>();
		// Adds the matching movie from the SQL Query to the arrayList movies
		while (rs.next()) {
			if (rs.getString("email").equals(email)) {
				Movie m = new Movie(rs.getString("title"), rs.getString("star"), rs.getString("year"), rs.getString("email"));
				movies.add(m);
			}
		}
		return movies;
	}

	// Method save() that takes in 4 parameters and then adds them to the SQL query which creates a new Movie in the DB
	public void save(String title, String star, String year, String email) throws Exception {

		Connection conn = getConnection();
		PreparedStatement psmt = conn.prepareStatement("INSERT INTO MOVIES VALUES('" + title + "', '" + star + "', '" + year + "', '" + email + "')");

		psmt.executeUpdate();
		psmt.close();
		conn.close();
	}

	// Method update() that takes in 4 parameters and then updates the movies star and year that matches both the passes parameters name and email
	public void update(String title, String star, String year, String email) throws Exception {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		PreparedStatement psmt = conn.prepareStatement("UPDATE MOVIES SET star = '" + star + "' WHERE title = '" + title + "' and email ='" + email + "'");
		PreparedStatement psmt2 = conn.prepareStatement("UPDATE MOVIES SET year = '" + year + "' WHERE title = '" + title + "' and email ='" + email + "'");
		psmt.executeUpdate();
		psmt2.executeUpdate();
		psmt.close();
		psmt2.close();
		conn.close();
	}

	// Method getMovieInfoForUpdate, takes in 2 parameters. Returns type Movie m
	public Movie getMovieInfoForUpdate(String title, String email) throws Exception {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM movies where email ='" + email + "' and title = '" + title + "'");
// if a movie in the DB matches the requested email and title, then that movie is set to MOvie m and returned
		while (rs.next()) {
			if (rs.getString("email").equals(email)) {
				Movie m = new Movie(rs.getString("title"), rs.getString("star"), rs.getString("year"), rs.getString("email"));
				return m;
			}
		}
return null;
}

// Method list(). with return of ArrayList of Movie
// Creates an Arraylist called Movies and then adds all the movies returned from the SQL query to that ArrayList.
	public ArrayList<Movie> list() throws Exception{
		ArrayList<Movie> Movies = new ArrayList();
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM movies");
		while (rs.next()) {
			Movie m = new Movie(rs.getString("TITLE"), rs.getString("STAR"), rs.getString("YEAR"), rs.getString("EMAIL") );
			Movies.add(m);
		}
		return Movies;
	}

	// Method delete().  Takes in 2 parameters and uses those in the SQL query to delete the matching Movie
	public void delete(String title, String email) throws Exception {
		JOptionPane.showMessageDialog(null, "Your Movie has been Deleted");
		try {
			if (!title.equals(null) || !title.equals("")) { // checks to see if the title not null or empty string
				Connection conn = getConnection();
				Statement stmt = conn.createStatement();
				int rs = stmt.executeUpdate("DELETE FROM movies where title = '" +title + "' and email = '" + email +"'");
			}else{
				JOptionPane.showMessageDialog(null, "Please enter a Movie to Delete");
				}
			}catch(Exception e){
			System.out.println("Something went wrong with Delete");
			e.printStackTrace();
		}
	}
}

