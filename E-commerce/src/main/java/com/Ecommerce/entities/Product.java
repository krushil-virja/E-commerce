package com.Ecommerce.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product {


   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String pname;
	private String pimage1;
	private String pimage2;
	private String pimage3;
	private String pimage4;
	private String brand;
	private int price;
	private String timedurestion;
	private String description;
	private String information;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private Category category;
	
	
	public Product(int id, String pname, String pimage1, String pimage2, String pimage3, String pimage4, String brand,
			int price, String timedurestion, String description, String information, Category category) {
		super();
		this.id = id;
		this.pname = pname;
		this.pimage1 = pimage1;
		this.pimage2 = pimage2;
		this.pimage3 = pimage3;
		this.pimage4 = pimage4;
		this.brand = brand;
		this.price = price;
		this.timedurestion = timedurestion;
		this.description = description;
		this.information = information;
		this.category = category;
	}
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPimage1() {
		return pimage1;
	}

	public void setPimage1(String pimage1) {
		this.pimage1 = pimage1;
	}

	public String getPimage2() {
		return pimage2;
	}

	public void setPimage2(String pimage2) {
		this.pimage2 = pimage2;
	}

	public String getPimage3() {
		return pimage3;
	}

	public void setPimage3(String pimage3) {
		this.pimage3 = pimage3;
	}

	public String getPimage4() {
		return pimage4;
	}

	public void setPimage4(String pimage4) {
		this.pimage4 = pimage4;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTimedurestion() {
		return timedurestion;
	}

	public void setTimedurestion(String timedurestion) {
		this.timedurestion = timedurestion;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
	
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", pname=" + pname + ", pimage1=" + pimage1 + ", pimage2=" + pimage2 + ", pimage3="
				+ pimage3 + ", pimage4=" + pimage4 + ", brand=" + brand + ", price=" + price + ", timedurestion="
				+ timedurestion + ", description=" + description + ", information=" + information + ", category="
				+ category + "]";
	}
	

}
