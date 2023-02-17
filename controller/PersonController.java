package com.ty.springboot_hospitalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hospitalproject.dto.Person;
import com.ty.springboot_hospitalproject.service.PersonService;
import com.ty.springboot_hospitalproject.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	@ApiOperation(value = "save person ", notes = "api is used to save person ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfuly saved"),
			@ApiResponse(code = 404, message = "id not found for given person")

	})

	@PostMapping("/person")
	public ResponseEntity<ResponseStructure<Person>> savePerson(@RequestBody Person person) {
		return personService.savePerson(person);

	}

	@ApiOperation(value = "update person ", notes = "api is used to update person ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfuly updated"),
			@ApiResponse(code = 404, message = "id not found for given person")

	})

	@PutMapping("/person/{id}")
	public ResponseEntity<ResponseStructure<Person>> updatePerson(@RequestBody Person person, @PathVariable int id) {
		return personService.savePerson(person);

	}

	@ApiOperation(value = "delete person ", notes = "api is used to delete person ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfuly deleted"),
			@ApiResponse(code = 404, message = "id not found for given person")

	})

	@DeleteMapping("/person/{id}")
	public ResponseEntity<ResponseStructure<Person>> deletePerson(@PathVariable int id) {
		return personService.deletePerson(id);

	}

	@ApiOperation(value = "fetch person ", notes = "api is used to fetch person ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfuly fetched"),
			@ApiResponse(code = 404, message = "id not found for given person")

	})

	@GetMapping("/person/{id}")
	public ResponseEntity<ResponseStructure<Person>> getPersonById(@PathVariable int id) {
		return personService.getPersonById(id);

	}

}
