package com.ty.springboot_hospitalproject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospitalproject.dto.Address;
import com.ty.springboot_hospitalproject.dto.Encounter;
import com.ty.springboot_hospitalproject.repository.EncounterRepository;

@Repository
public class EncounterDao {

	@Autowired
	private EncounterRepository repo;

	public Encounter saveEncounter(Encounter encounter) {

		return repo.save(encounter);

	}

	public Encounter updateEncounter(int eid, Encounter encounter) {

		if (repo.findById(eid).isPresent()) {
			encounter.setId(eid);

			return repo.save(encounter);

		}

		else
			return null;
	}

	public Encounter deleteEncounter(int id) {
		if (repo.findById(id).isPresent()) {
			Encounter encounter = repo.findById(id).get();
			repo.delete(encounter);

			return encounter;

		} else {
			return null;
		}
	}

	public Encounter getById(int eid) {
		return repo.findById(eid).get();
	}

}
