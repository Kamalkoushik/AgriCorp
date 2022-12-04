package com.jfsd.model;

import javax.persistence.*;

@Entity
@Table(name = "admin_table")
public class Admin {

	@Id
	@Column(length = 50)
	private String username;
	@Column(nullable = false, length = 50)
	private String password;
	
	@Override
	public String toString() {
		return "Admin [username=" + username + ", password=" + password + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
