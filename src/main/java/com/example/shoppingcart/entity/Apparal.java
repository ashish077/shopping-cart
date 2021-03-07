package com.example.shoppingCart.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the apparal database table.
 * 
 */
@Entity
@Table(name="apparal")
@NamedQuery(name="Apparal.findAll", query="SELECT a FROM Apparal a")
@PrimaryKeyJoinColumn(name="P_product_id")
public class Apparal extends Product {
	private static final long serialVersionUID = 1L;

	@Column(name="Type")
	private String type;

	@Column(name="Brand")
	private String brand;

	@Column(name="Design")
	private String design;

	
	public Apparal() {
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDesign() {
		return this.design;
	}

	public void setDesign(String design) {
		this.design = design;
	}


}