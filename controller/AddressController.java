package com.ty.springboot_hospitalproject.controller;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hospitalproject.dto.Address;
import com.ty.springboot_hospitalproject.service.AddressService;
import com.ty.springboot_hospitalproject.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class AddressController {

	@Autowired
	private AddressService service;

	@ApiOperation(value = "save address ", notes = "api is used to save address ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfuly saved"),
			@ApiResponse(code = 404, message = "id not found for given address")

	})

	@PostMapping("/saveaddress")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address) {
		return service.saveAddress(address);
	}

	@ApiOperation(value = "update address ", notes = "api is used to update address ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfuly updated"),
			@ApiResponse(code = 404, message = "id not found for given address")

	})

	@PutMapping("/updateaddress")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestParam int id,
			@RequestBody Address address) {
		return service.updateAddress(id, address);
	}

	@ApiOperation(value = "delete address ", notes = "api is used to delete address ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfuly deleted"),
			@ApiResponse(code = 404, message = "id not found for given address")

	})

	@DeleteMapping("/deleteaddress")
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(@RequestParam int id) {
		return service.deleteAddress(id);
	}

	@ApiOperation(value = "fetch address ", notes = "api is used tofetch address ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfuly fetched"),
			@ApiResponse(code = 404, message = "id not found for given address")

	})

	@GetMapping("/getaddress")
	public ResponseEntity<ResponseStructure<Address>> getAddressById(@RequestParam int id) {
		return service.getAddressById(id);
	}

}
