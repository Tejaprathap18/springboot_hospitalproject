package com.ty.springboot_hospitalproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_hospitalproject.dto.Branch;
import com.ty.springboot_hospitalproject.dto.Hospital;

public interface BranchRepository extends JpaRepository<Branch, Integer>{
	
	public List<Branch> getByHospital(Hospital hospital);

}
