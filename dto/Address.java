package com.ty.springboot_hospitalproject.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull(message = "city cannot be null")
	@NotBlank(message = "city cannot be blank")
	private String city;

	@NotNull(message = "area cannot be null")
	@NotBlank(message = "area cannot be blank")
	private String area;

	@NotNull(message = "street cannot be null")
	@NotBlank(message = "street cannot be blank")
	private String street;

	@NotNull(message = "state cannot be null")
	@NotBlank(message = "state cannot be blank")
	private String state;

	private int pincode;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

}
