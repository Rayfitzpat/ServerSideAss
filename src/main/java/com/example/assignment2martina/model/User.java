package com.example.assignment2martina.model;

public class User {
	private String email;
	private String name;
	private String password;
	
	public User(String n, String e,  String p) {
		this.email = e;
		this.name = n;
		this.password=p;
	}
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
