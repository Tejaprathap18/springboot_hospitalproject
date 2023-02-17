package com.ty.springboot_hospitalproject.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.Data;

@Entity
@Data
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "name cannot be null")
	@NotBlank(message = "name cannot be blank")
	private String name;
	

	@NotNull(message = "email cannot be null")
	@NotBlank(message = "email cannot be blank")
	private String email;
	private long phone;
}
