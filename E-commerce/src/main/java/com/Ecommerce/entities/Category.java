package com.Ecommerce.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cateory")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String cname;
	private String cimage;
	
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public String getCimage() {
		return cimage;
	}


	public void setCimage(String cimage) {
		this.cimage = cimage;
	}
	
	
	public Category(int id, String cname, String cimage) {
		super();
		this.id = id;
		this.cname = cname;
		this.cimage = cimage;
	}


	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", cname=" + cname + ", cimage=" + cimage + "]";
	}

	
	
	
	

}
