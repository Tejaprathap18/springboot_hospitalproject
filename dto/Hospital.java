package com.ty.springboot_hospitalproject.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Hospital {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message="name should nt be null")
	private String name;
	
	@NotNull(message="email is mandatory")
	private String email;
	
	@NotNull(message="gst cant be null")
	@NotBlank
	private String gst;
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
	public String getGst() {
		return gst;
	}
	public void setGst(String gst) {
		this.gst = gst;
	}
	
	
	@Override
	public String toString() {
		return "Hospital [id=" + id + ", name=" + name + ", email=" + email + ", gst=" + gst + "]";
	}

	
}
