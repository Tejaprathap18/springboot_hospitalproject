package com.ty.springboot_hospitalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospitalproject.dao.PersonDao;
import com.ty.springboot_hospitalproject.dto.Address;
import com.ty.springboot_hospitalproject.dto.Person;
import com.ty.springboot_hospitalproject.exception.IdNotFoundException;
import com.ty.springboot_hospitalproject.util.ResponseStructure;

@Service
public class PersonService {
	
	@Autowired
	private PersonDao personDao;
	
	public ResponseEntity<ResponseStructure<Person>> savePerson(Person person){
		
		
		ResponseStructure<Person> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("successfully saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(personDao.savePerson(person));
		
		
		return new ResponseEntity<ResponseStructure<Person>>(responseStructure,HttpStatus.CREATED);
	}
	
public ResponseEntity<ResponseStructure<Person>> updatePerson(int id ,Person person){
		
		Person person2=personDao.updatePerson(person, id);
		if(person2!=null) {
			ResponseStructure<Person> responseStructure=new ResponseStructure<Person>();
			responseStructure.setMessage("successfully updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(person2);;
			
			return new ResponseEntity<ResponseStructure<Person>>(responseStructure, HttpStatus.OK);
		}else {
			throw new IdNotFoundException("Given Id Not Found");
		}
		
	}
public ResponseEntity<ResponseStructure<Person>> deletePerson(int id){
	Person person=personDao.deletePerson(id);
	if(person!=null) {
		ResponseStructure<Person> responseStructure=new ResponseStructure<Person>();
		responseStructure.setMessage("successfully deleted");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(person);
		
		return new ResponseEntity<ResponseStructure<Person>>(responseStructure, HttpStatus.OK);
	}else {
		throw new IdNotFoundException("Given Id Not Found");
		
	}
}

public ResponseEntity<ResponseStructure<Person>> getPersonById(int id){
	Person person=personDao.getPersonById(id);
	if(person!=null) {
		ResponseStructure<Person> responseStructure=new ResponseStructure<	Person>();
		responseStructure.setMessage("Found");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setData(person);
		
		return new ResponseEntity<ResponseStructure<Person>>(responseStructure, HttpStatus.FOUND);
	}else {
		throw new IdNotFoundException("Given Id Not Found");
		
	}
}


}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


