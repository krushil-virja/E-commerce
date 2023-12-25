package com.Ecommerce.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="user")
public class User {
	

	@Id
     @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotBlank(message="User Name can not be a null")
	@Size(min=3 , max=12, message="User Name must be between 3-12 characters")
	private String name;
	
	@NotBlank(message="Email is mandatory")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
	private String email;
	
	@NotBlank(message="Password can not be a null")
	private String password;
	private String role;
	
	@NotBlank(message="contact is mandatory")
	@Size(min=10 , max=10, message="Contact could be only a 10-digit number.")
	private String contact;
	
	@NotBlank(message="city is mandatory")
	private String city;
	
	@Min(value = 10000, message = "Pincode must be at least 10000")
    @Max(value = 99999, message = "Pincode cannot be more than 99999")
	private int pincode;
	
	
	public User(int id, String name, String email, String password, String role, String contact, String city,
			int pincode) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.contact = contact;
		this.city = city;
		this.pincode = pincode;
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
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



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
	
	
    public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}




	public String getContact() {
		return contact;
	}



	public void setContact(String contact) {
		this.contact = contact;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public int getPincode() {
		return pincode;
	}



	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", contact=" + contact + ", city=" + city + ", pincode=" + pincode + "]";
	}


	

}
