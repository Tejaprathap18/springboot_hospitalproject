package com.ty.springboot_hospitalproject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospitalproject.dto.Address;
import com.ty.springboot_hospitalproject.dto.Person;
import com.ty.springboot_hospitalproject.repository.PersonRepository;

@Repository
public class PersonDao {

	@Autowired
	private PersonRepository repo;

	public Person savePerson(Person person) {

		return repo.save(person);

	}

	public Person updatePerson(Person person, int id) {

		if (repo.findById(id).isPresent()) {

			person.setId(id);

			return repo.save(person);
		} else
			return null;
	}

	public Person deletePerson(int id) {
		if (repo.findById(id).isPresent()) {
			Person person = repo.findById(id).get();
			repo.delete(person);
			return person;
		} else {
			return null;
		}
	}

	public Person getPersonById(int id) {
		if (repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		} else {
			return null;
		}
	}

}
