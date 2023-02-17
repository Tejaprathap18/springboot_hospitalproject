package com.ty.springboot_hospitalproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospitalproject.dao.EncounterDao;
import com.ty.springboot_hospitalproject.dao.MedOrderDao;
import com.ty.springboot_hospitalproject.dto.Address;
import com.ty.springboot_hospitalproject.dto.Branch;
import com.ty.springboot_hospitalproject.dto.Encounter;
import com.ty.springboot_hospitalproject.dto.MedOrder;
import com.ty.springboot_hospitalproject.dto.Person;
import com.ty.springboot_hospitalproject.exception.IdNotFoundException;
import com.ty.springboot_hospitalproject.util.ResponseStructure;

@Service
public class MedOrderService {

	@Autowired
	private MedOrderDao mDao;

	@Autowired
	private EncounterDao edDao;

	public ResponseEntity<ResponseStructure<MedOrder>> saveMedorder(MedOrder medOrder, int eid) {

		Encounter encounter = edDao.getById(eid);
		medOrder.setEncounter(encounter);

		ResponseStructure<MedOrder> structure = new ResponseStructure<MedOrder>();

		structure.setMessage("successfully saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(mDao.saveMedorder(medOrder));

		return new ResponseEntity<ResponseStructure<MedOrder>>(structure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(MedOrder medOrder, int mid) {

		MedOrder medOrder2 = mDao.getMedorderById(mid);

		if (medOrder2 != null) {
			medOrder.setEncounter(medOrder2.getEncounter());
			ResponseStructure<MedOrder> structure = new ResponseStructure<MedOrder>();

			structure.setMessage("successfully updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(mDao.updateMedOrder(medOrder, mid));

			return new ResponseEntity<ResponseStructure<MedOrder>>(structure, HttpStatus.OK);

		} else
			throw new IdNotFoundException();

	}

	public ResponseEntity<ResponseStructure<MedOrder>> deleteMedorder(int id) {
		MedOrder medOrder = mDao.deleteMedorder(id);

		if (medOrder != null) {
			ResponseStructure<MedOrder> responseStructure = new ResponseStructure<MedOrder>();
			responseStructure.setMessage("successfully deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(medOrder);
			return new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id not Found");
		}

	}

	public ResponseEntity<ResponseStructure<MedOrder>> getMedorder(int id) {
		MedOrder medOrder = mDao.getMedorderById(id);
		if (medOrder != null) {
			ResponseStructure<MedOrder> responseStructure = new ResponseStructure<MedOrder>();
			responseStructure.setMessage("Found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(medOrder);

			return new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("Given Id Not Found");

		}
	}

	public ResponseEntity<ResponseStructure<List<MedOrder>>> getAllMedorderByEncounter(int id) {
		List<MedOrder> medOrders = mDao.getAllMedOrderByEncounter(id);
		if (medOrders != null) {
			ResponseStructure<List<MedOrder>> responseStructure = new ResponseStructure<List<MedOrder>>();
			responseStructure.setMessage("Found all");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(medOrders);

			return new ResponseEntity<ResponseStructure<List<MedOrder>>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("Given Id Not Found");

		}
	}

}
