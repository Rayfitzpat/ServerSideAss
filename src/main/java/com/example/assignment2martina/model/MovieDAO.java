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

	public Connection getConnection() throws Exception {


		Class.forName("org.hsqldb.jdbcDriver");


		Connection con = DriverManager.getConnection(
				"jdbc:hsqldb:hsql://localhost/oneDB", "sa", "");

		return con;
	}

	public ArrayList<Movie> selectOne(String email) throws Exception {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM movies  where email ='" + email + "'");

		ArrayList<Movie> movies = new ArrayList<>();
		while (rs.next()) {

			if (rs.getString("email").equals(email)) {

				Movie m = new Movie(rs.getString("title"), rs.getString("star"), rs.getString("year"), rs.getString("email"));
				movies.add(m);
			}
		}
		return movies;
	}


	public void save(String title, String star, String year, String email) throws Exception {

		Connection conn = getConnection();
		PreparedStatement psmt = conn.prepareStatement("INSERT INTO MOVIES VALUES('" + title + "', '" + star + "', '" + year + "', '" + email + "')");

//		psmt.setString(1, m.getTitle());
//		psmt.setString(2, m.getStar());
//		psmt.setString(3, m.getYear());
//		psmt.setString(3, m.getEmail());

		psmt.executeUpdate();
		psmt.close();
		conn.close();
	}

	public void update(String title, String star, String year, String email) throws Exception {
		System.out.println("before connection");
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		System.out.println("before update 1");
		PreparedStatement psmt = conn.prepareStatement("UPDATE MOVIES SET star = '" + star + "' WHERE title = '" + title + "' and email ='" + email + "'");
		System.out.println("After update 1");
		PreparedStatement psmt2 = conn.prepareStatement("UPDATE MOVIES SET year = '" + year + "' WHERE title = '" + title + "' and email ='" + email + "'");
		System.out.println("After update 2");
		psmt.executeUpdate();
		psmt2.executeUpdate();
		psmt.close();
		psmt2.close();
		conn.close();
//		ResultSet rs = stmt.executeUpdate("UPDATE MOVIE SET star = '" + star +"' year = '" + year +"' WHERE title = '" + title + "' and email ='" + email +"'");

//		while (rs.next()) {
//			if (rs.getString("email").equals(email)) {
//
//				Movie m = new Movie(rs.getString("title"), rs.getString("star"), rs.getString("year"), rs.getString("email"));
//				return m;
//			}
//		}
//		return null;
//	}
	}


	public Movie getMovieInfoForUpdate(String title, String email) throws Exception {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM movies where email ='" + email + "' and title = '" + title + "'");

		while (rs.next()) {
			if (rs.getString("email").equals(email)) {

				Movie m = new Movie(rs.getString("title"), rs.getString("star"), rs.getString("year"), rs.getString("email"));
				return m;
			}
		}
return null;
}


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

	public void delete(String title, String email) throws Exception {
		JOptionPane.showMessageDialog(null, "Your Movie has been Deleted");
		try {
			if (!title.equals(null) || !title.equals("")) {
				Connection conn = getConnection();
				Statement stmt = conn.createStatement();
				int rs = stmt.executeUpdate("DELETE FROM movies where title = '" +title + "' and email = '" + email +"'");
			}else{
				JOptionPane.showMessageDialog(null, "Please enter a Movie to Delete");
				}
			}catch(Exception e){
			System.out.println("Something went wrong");
			e.printStackTrace();
		}
	}
}

