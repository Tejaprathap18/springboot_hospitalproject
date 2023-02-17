package com.ty.springboot_hospitalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hospitalproject.dto.Branch;
import com.ty.springboot_hospitalproject.service.BranchService;
import com.ty.springboot_hospitalproject.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BranchController {

	@Autowired
	private BranchService branchService;

	@ApiOperation(value = "save Branch ", notes = "api is used to save branch ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfuly saved"),
			@ApiResponse(code = 404, message = "id not found for given branch")

	})

	@PostMapping("/savebranch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestParam int hid, @RequestParam int aid,
			@RequestBody Branch branch) {
		return branchService.saveBranch(branch, hid, aid);
	}

	@ApiOperation(value = "update Branch ", notes = "api is used to update branch ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfuly updated"),
			@ApiResponse(code = 404, message = "id not found for given branch")

	})

	@PutMapping("/updatebranch")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestParam int bid, @RequestBody Branch branch) {
		return branchService.updateBranch(branch, bid);
	}

	@ApiOperation(value = "delete Branch ", notes = "api is used to delete branch ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfuly deleted"),
			@ApiResponse(code = 404, message = "id not found for given branch")

	})

	@DeleteMapping("/deletebranch")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(@RequestParam int id) {
		return branchService.deleteBranch(id);
	}

	@ApiOperation(value = "fetch Branch ", notes = "api is used to fetch branch ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfuly fetched"),
			@ApiResponse(code = 404, message = "id not found for given branch")

	})
	@GetMapping("/getbranch")
	public ResponseEntity<ResponseStructure<Branch>> getBranchById(@RequestParam int id) {
		return branchService.getBranchById(id);
	}

	@ApiOperation(value = "fetchAll Branch ", notes = "api is used to fetch branch ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfuly fetched"),
			@ApiResponse(code = 404, message = "id not found for given branch")

	})

	@GetMapping("/getallbranch")
	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranchByHospital(@RequestParam int hid) {
		return branchService.getAllBranchByHospital(hid);
	}

}
