package com.example.assignment2martina.model;

public class Movie {
	// Movie parameters
	private String title;
	private String star;
	private String year;
	private String email;

	// Movie Constructor
	public Movie(String t, String s, String y, String e) {
		this.title=t;
		this.star = s;
		this.year = y;
		this.email = e;
	}

	// Movie Getters and Setters
	public String getTitle() {

		return title;
	}

	public void setTitle(String title) {

		this.title = title;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
