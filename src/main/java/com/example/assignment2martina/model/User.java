package com.example.assignment2martina.model;

// User parameters
public class User {
	private String email;
	private String name;
	private String password;

	// User Constructor
	public User(String n, String e,  String p) {
		this.email = e;
		this.name = n;
		this.password=p;
	}

	// User Getters and Setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public String getPassword() {
		return this.password;
	}
	
	public void setName(String n) {
		this.name = n;
	}

	public void setPassword(String a) {
		this.password = a;
	}
}
