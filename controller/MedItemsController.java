package com.ty.springboot_hospitalproject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hospitalproject.dto.MedItems;
import com.ty.springboot_hospitalproject.dto.MedOrder;
import com.ty.springboot_hospitalproject.service.MedItemsService;
import com.ty.springboot_hospitalproject.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MedItemsController {

	@Autowired
	private MedItemsService mService;

	@PostMapping("/meditems/{mid}")

	@ApiOperation(value = "Save Meditems ", notes = "api is used to save meditems ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfuly saved"),
			@ApiResponse(code = 404, message = "id not found for given meditems")

	})

	public ResponseEntity<ResponseStructure<MedItems>> saveMedItems(@Valid @RequestBody MedItems medItems,
			@PathVariable int mid) {
		return mService.saveMedItems(medItems, mid);

	}

	@ApiOperation(value = "update Meditems ", notes = "api is used to update meditems ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfuly updated"),
			@ApiResponse(code = 404, message = "id not found for given meditems")

	})

	@PutMapping("/meditems/{mid}")
	public ResponseEntity<ResponseStructure<MedItems>> updateMeditems(@PathVariable int mid,
			@RequestBody MedItems medItems) {
		return mService.updateMedItems(medItems, mid);
	}

	@ApiOperation(value = "delete Meditems ", notes = "api is used to delete meditems ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfuly deleted"),
			@ApiResponse(code = 404, message = "id not found for given meditems")

	})

	@DeleteMapping("/meditems/{id}")
	public ResponseEntity<ResponseStructure<MedItems>> deleteMeditems(@PathVariable int id) {
		return mService.deleteMedItems(id);
	}

	@ApiOperation(value = "find Meditems by id", notes = "api is used to fetch meditems by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfuly fetched"),
			@ApiResponse(code = 404, message = "id not found for given meditems")

	})

	@GetMapping("/meditems/{id}")
	public ResponseEntity<ResponseStructure<MedItems>> getMeditemsById(@PathVariable int id) {
		return mService.getMeditemsById(id);
	}

}
