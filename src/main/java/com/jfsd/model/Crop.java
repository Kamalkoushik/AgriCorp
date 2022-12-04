package com.jfsd.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "crop_table")
public class Crop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "crop_id_generator")
	@SequenceGenerator(name = "crop_id_generator", initialValue = 1, allocationSize = 1)
	private int id;
	@Column(nullable=false)
	private String cropname;
	@Column(nullable=false)
	private double quantity;
	@Column(nullable=false)
	private int supplierid;
	
	public int getSupplier() {
		return supplierid;
	}

	public void setSupplier(int supplier) {
		this.supplierid = supplier;
	}

	@Override
	public String toString() {
		return "Crop [id=" + id + ", name=" + cropname + ", quantity=" + quantity + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCropname() {
		return cropname;
	}

	public void setCropname(String cropname) {
		this.cropname = cropname;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}	
	
}
