package com.jfsd.model;

import javax.persistence.*;

@Entity
@Table(name = "complain_table")
public class Complain {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "complain_id_generator")
	@SequenceGenerator(name = "complain_id_generator", initialValue = 1, allocationSize = 1)
	private int id;
	@Column
	private String farmername;
	@Column
	private String complaintype;
	@Column
	private String complain;
	
	@Override
	public String toString() {
		return "Complain [id=" + id + ", farmername=" + farmername + ", complaintype=" + complaintype + ", complain="
				+ complain + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFarmername() {
		return farmername;
	}

	public void setFarmername(String farmername) {
		this.farmername = farmername;
	}

	public String getComplaintype() {
		return complaintype;
	}

	public void setComplaintype(String complaintype) {
		this.complaintype = complaintype;
	}

	public String getComplain() {
		return complain;
	}

	public void setComplain(String complain) {
		this.complain = complain;
	} 
	
}
