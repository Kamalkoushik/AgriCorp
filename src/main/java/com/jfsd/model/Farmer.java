package com.jfsd.model;

import javax.persistence.*;

@Entity
@Table(name = "Farmer_table")
public class Farmer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "farmer_id_generator")
	@SequenceGenerator(name = "farmer_id_generator", initialValue = 1, allocationSize = 1)
	private int id;
	@Column(nullable = false, length = 50)
	private String name;
	@Column(nullable = false, length = 50)
	private String gender;
	@Column(nullable = false, unique = true, length = 50)
	private String email;
	@Column(nullable = false, unique = true, length = 50)
	private String username;
	@Column(nullable = false, length = 50)
	private String password;
	@Column(nullable = false, unique = true, length = 10)
	private String contactno;
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", gender=" + gender + ", email=" + email + ", username="
				+ username + ", password=" + password + ", contactno=" + contactno + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	
}
