package com.jfsd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name="supplier_table")
public class Supplier 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_id_generator")
	@SequenceGenerator(name = "supplier_id_generator", initialValue = 1, allocationSize = 1)
	int id;
	@Column(nullable=false,unique=true)
	String username;
	@Column(nullable=false, length=10)
	String name;
	@Column(nullable=false)
	@Size(min = 8, max = 15)
	String password;
	@Column(nullable=false,unique=true)
	@Email(message = "Please enter a valid e-mail address")
	String email;
	@Column(nullable=false,unique=true)
	String phone_number;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	@Override
	public String toString() {
		return "Supplier [id=" + id + ", username=" + username + ", name=" + name + ", password=" + password
				+ ", email=" + email + ", phone_number=" + phone_number + "]";
	}
	
}
