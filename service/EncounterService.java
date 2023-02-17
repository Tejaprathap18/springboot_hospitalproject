package com.ty.springboot_hospitalproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospitalproject.dao.BranchDao;
import com.ty.springboot_hospitalproject.dao.EncounterDao;
import com.ty.springboot_hospitalproject.dao.PersonDao;
import com.ty.springboot_hospitalproject.dto.Branch;
import com.ty.springboot_hospitalproject.dto.Encounter;
import com.ty.springboot_hospitalproject.dto.Person;
import com.ty.springboot_hospitalproject.exception.IdNotFoundException;
import com.ty.springboot_hospitalproject.util.ResponseStructure;

@Service
public class EncounterService {

	@Autowired
	private PersonDao personDao;

	@Autowired
	private EncounterDao encounterDao;

	@Autowired
	private BranchDao branchDao;

	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter, int pid, int bid) {

		Person person = personDao.getPersonById(pid);
		Branch branch = branchDao.getBranchById(bid);
		ResponseStructure<Encounter> structure = new ResponseStructure<Encounter>();

		structure.setMessage("successfully saved");
		structure.setStatus(HttpStatus.CREATED.value());
		encounter.setPerson(person);
		List<Branch> branches = new ArrayList<>();
		branches.add(branch);

		encounter.setBranchs(branches);
		structure.setData(encounterDao.saveEncounter(encounter));

		return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(Encounter encounter, int eid, int bid) {

		Encounter daoEncounter = encounterDao.getById(eid);
		Branch branch = branchDao.getBranchById(bid);

		List<Branch> list = daoEncounter.getBranchs();
		list.add(branch);

		encounter.setBranchs(list);
		encounter.setPerson(daoEncounter.getPerson());

		ResponseStructure<Encounter> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("update success");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(encounterDao.updateEncounter(eid, encounter));

		return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(int id) {

		Encounter daoEncounter = encounterDao.deleteEncounter(id);
		if (daoEncounter != null) {
			ResponseStructure<Encounter> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("successfully deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(daoEncounter);
			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id not Found");
		}

	}

	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(int id) {

		Encounter encounter = encounterDao.getById(id);
		if (encounter != null) {
			ResponseStructure<Encounter> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(encounter);
			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("Id not Found");
		}

	}

}
