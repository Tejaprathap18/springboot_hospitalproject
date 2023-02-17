package com.ty.springboot_hospitalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_hospitalproject.dto.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer>{
	
	public Hospital getByEmail(String email);

}
