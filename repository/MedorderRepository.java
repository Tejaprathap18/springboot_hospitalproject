
package com.ty.springboot_hospitalproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_hospitalproject.dto.Encounter;
import com.ty.springboot_hospitalproject.dto.MedOrder;

public interface MedorderRepository extends JpaRepository<MedOrder, Integer> {

	
	public List<MedOrder> getByEncounter(Encounter encounter);
}
