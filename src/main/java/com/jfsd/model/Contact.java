package com.jfsd.model;

import javax.persistence.*;

@Entity
@Table(name = "contact_table")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_id_generator")
	@SequenceGenerator(name = "contact_id_generator", initialValue = 1, allocationSize = 1)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String Email;
	@Column(nullable = false)
	private String phno;
	@Column(nullable = false)
	private String maessage;
	
	public String getMaessage() {
		return maessage;
	}
	public void setMaessage(String maessage) {
		this.maessage = maessage;
	}
	
}
