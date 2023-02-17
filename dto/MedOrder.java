package com.ty.springboot_hospitalproject.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
public class MedOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@CreationTimestamp
	private Date date;

	@NotBlank(message = "doctor cannot be blank")
	@NotNull(message = "doctor cannot be blank")
	private String doctor;

	@ManyToOne
	private Encounter encounter;
}
