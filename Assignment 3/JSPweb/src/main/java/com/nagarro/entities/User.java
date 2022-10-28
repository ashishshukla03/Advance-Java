package com.nagarro.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	private String username;
	private String password;
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User() {
		super();
	}
	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getUserPassword() {
		return password;
	}

	public void setUserPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		System.out.println("sdsdsjdh");
		return "User [username=" + username + ", password=" + password + "]";
	}
}
