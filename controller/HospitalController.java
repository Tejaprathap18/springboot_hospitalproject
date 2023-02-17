package com.ty.springboot_hospitalproject.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hospitalproject.dto.Hospital;
import com.ty.springboot_hospitalproject.service.HospitalService;
import com.ty.springboot_hospitalproject.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class HospitalController {

	@Autowired
	private HospitalService service;

	@ApiOperation(value = "Save hospital ", notes = "api is used to save hospital ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfuly saved"),
			@ApiResponse(code = 404, message = "id not found for given hospital")

	})

	@PostMapping("/savehospital")
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@Valid @RequestBody Hospital hospital) {
		return service.saveHospital(hospital);
	}

	@ApiOperation(value = "update hospital ", notes = "api is used to update hospital ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfuly updated"),
			@ApiResponse(code = 404, message = "id not found for given hospital")

	})

	@PutMapping("/updatehospital")
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@RequestParam int id,
			@RequestBody Hospital hospital) {
		return service.updateHospital(id, hospital);
	}

	@ApiOperation(value = "delete hospital ", notes = "api is used to delete hospital ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfuly deleted"),
			@ApiResponse(code = 404, message = "id not found for given hospital")

	})

	@DeleteMapping("/deletehospital")
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(@RequestParam int id) {
		return service.deleteHospital(id);
	}

	@ApiOperation(value = "fetch hospital ", notes = "api is used to fetch hospital ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfuly fetched"),
			@ApiResponse(code = 404, message = "id not found for given hospital")

	})

	@GetMapping("/gethospital")
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(@RequestParam int id) {
		return service.getHospitalById(id);
	}

}
