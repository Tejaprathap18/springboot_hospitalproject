package com.ty.springboot_hospitalproject.controller;

import java.util.List;

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

import com.ty.springboot_hospitalproject.dto.Hospital;
import com.ty.springboot_hospitalproject.dto.MedOrder;
import com.ty.springboot_hospitalproject.service.MedOrderService;
import com.ty.springboot_hospitalproject.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MedOrderController {

	@Autowired
	private MedOrderService mService;

	@ApiOperation(value = "Save Medorder ", notes = "api is used to save medorder ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfuly saved"),
			@ApiResponse(code = 404, message = "id not found for given medorder")

	})

	@PostMapping("/medorder/{id}")
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(@RequestBody MedOrder medOrder,
			@PathVariable int id) {
		return mService.saveMedorder(medOrder, id);

	}

	@ApiOperation(value = "update Medorder ", notes = "api is used to update medorder ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfuly updated"),
			@ApiResponse(code = 404, message = "id not found for given medorder")

	})

	@PutMapping("/medorder/{mid}")
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedorder(@PathVariable int mid,
			@RequestBody MedOrder medOrder) {
		return mService.updateMedOrder(medOrder, mid);
	}

	@ApiOperation(value = "delete Medorder ", notes = "api is used to delete medorder ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfuly deleted"),
			@ApiResponse(code = 404, message = "id not found for given medorder")

	})

	@DeleteMapping("/medorder/{id}")
	public ResponseEntity<ResponseStructure<MedOrder>> deleteMedorder(@PathVariable int id) {
		return mService.deleteMedorder(id);
	}

	@ApiOperation(value = "find Medorder by id ", notes = "api is used to fetch medorder ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfuly fetched"),
			@ApiResponse(code = 404, message = "id not found for given medorder")

	})

	@GetMapping("/medorder/{id}")
	public ResponseEntity<ResponseStructure<MedOrder>> getMedorderById(@PathVariable int id) {
		return mService.getMedorder(id);
	}

	@ApiOperation(value = "fetch all medorders ", notes = "api is used to fetch all medorder ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfuly fetched"),
			@ApiResponse(code = 404, message = "id not found for given medorder")

	})

	@GetMapping("/medorderall/{eid}")
	public ResponseEntity<ResponseStructure<List<MedOrder>>> getAllMedorders(@PathVariable int eid) {
		return mService.getAllMedorderByEncounter(eid);
	}

}
