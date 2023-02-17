package com.ty.springboot_hospitalproject.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull(message = "name cannot be null")
	@NotBlank(message = "name cannot be blank")
	private String name;

	@NotNull(message = "manager cannot be null")
	@NotBlank(message = "manager cannot be blank")
	private String manager;

	@NotNull(message = "phone no cannot be null")
	@NotBlank(message = " phone no cannot be blank")
	private String phone;

	@ManyToOne
	private Hospital hospital;

	@OneToOne
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
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

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Branch [id=" + id + ", name=" + name + ", manager=" + manager + ", phone=" + phone + ", hospital="
				+ hospital + ", address=" + address + "]";
	}

	

	
}
