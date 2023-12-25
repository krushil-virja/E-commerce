package com.Ecommerce.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="contact")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank(message="Name is Mandatory")
	private String name;
	
	@NotBlank(message="Email is Mandatory")
	private String email;
	private String subject;
	private String message;
	
	
	


	public Contact(int id, String name, String email, String subject, String message) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.message = message;
	}
	
	
	public Contact() {
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


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", email=" + email + ", subject=" + subject + ", message="
				+ message + "]";
	}

	
}
