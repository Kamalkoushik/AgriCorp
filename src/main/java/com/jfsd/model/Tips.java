package com.jfsd.model;
import javax.persistence.*;

@Entity
@Table(name = "tips_table")
public class Tips 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tips_id_generator")
	@SequenceGenerator(name = "tips_id_generator", initialValue = 1, allocationSize = 1)
	private int id;

	@Column
    private String tip;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
}