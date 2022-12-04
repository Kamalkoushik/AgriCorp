package com.jfsd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="sellcrop_table")
public class SellCrop 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "crop_id_generator")
	@SequenceGenerator(name = "crop_id_generator", initialValue = 1, allocationSize = 1)
	int id;
	@Column(nullable=false)
	int cropid;
	@Column(nullable=false)
	String cropname;
	@Column(nullable=false)
	int farmerid;
	@Column(nullable=false)
	String farmername;
	@Column(nullable=false)
	int quantity;
	@Column(nullable=false)
	double cost;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCropid() {
		return cropid;
	}
	public void setCropid(int cropid) {
		this.cropid = cropid;
	}
	public String getCropname() {
		return cropname;
	}
	public void setCropname(String cropname) {
		this.cropname = cropname;
	}
	public int getFarmerid() {
		return farmerid;
	}
	public void setFarmerid(int farmerid) {
		this.farmerid = farmerid;
	}
	public String getFarmername() {
		return farmername;
	}
	public void setFarmername(String farmername) {
		this.farmername = farmername;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
}
