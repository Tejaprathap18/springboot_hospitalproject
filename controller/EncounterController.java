package com.ty.springboot_hospitalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hospitalproject.dto.Address;
import com.ty.springboot_hospitalproject.dto.Encounter;
import com.ty.springboot_hospitalproject.service.EncounterService;
import com.ty.springboot_hospitalproject.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EncounterController {

	@Autowired
	private EncounterService encounterService;

	@ApiOperation(value = "Save Encounter ", notes = "api is used to save encounter ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfuly saved"),
			@ApiResponse(code = 404, message = "id not found for given encounter")

	})

	@PostMapping("/encounter")
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(@RequestBody Encounter encounter,
			@RequestParam int pid, @RequestParam int bid) {

		return encounterService.saveEncounter(encounter, pid, bid);

	}

	@ApiOperation(value = "update Encounter ", notes = "api is used to update encounter ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfuly updated"),
			@ApiResponse(code = 404, message = "id not found for given encounter")

	})

	@PutMapping("/encounter")
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(@RequestBody Encounter encounter,
			@RequestParam int eid, @RequestParam int bid) {

		return encounterService.updateEncounter(encounter, eid, bid);

	}

	@ApiOperation(value = "delete Encounter ", notes = "api is used to delete encounter ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfuly deleted"),
			@ApiResponse(code = 404, message = "id not found for given encounter")

	})

	@DeleteMapping("/encounter/{id}")
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(@PathVariable int id) {
		return encounterService.deleteEncounter(id);
	}

	@ApiOperation(value = "Fetch Encounter ", notes = "api is used to fetch encounter ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfuly fetched"),
			@ApiResponse(code = 404, message = "id not found for given encounter")

	})

	@GetMapping("/encounter/{id}")
	public ResponseEntity<ResponseStructure<Encounter>> getAddressById(@PathVariable int id) {
		return encounterService.getEncounterById(id);
	}

}
