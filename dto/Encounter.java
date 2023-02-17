package com.ty.springboot_hospitalproject.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Encounter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "reason cannot be null")
	@NotBlank(message = "reason cannot be blank")
	private String reason;
	
	@NotNull(message = "cost cannot be null")
	@NotBlank(message = "cost cannot be blank")
	private String  cost;
	
	@ManyToOne
	private Person person;
	
	@OneToMany
	List<Branch>branchs;
}
