package com.ty.springboot_hospitalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospitalproject.dao.MedItemsDao;
import com.ty.springboot_hospitalproject.dao.MedOrderDao;
import com.ty.springboot_hospitalproject.dto.MedItems;
import com.ty.springboot_hospitalproject.dto.MedOrder;
import com.ty.springboot_hospitalproject.exception.IdNotFoundException;
import com.ty.springboot_hospitalproject.util.ResponseStructure;

@Service
public class MedItemsService {

	@Autowired
	private MedItemsDao mDao;
	@Autowired
	private MedOrderDao mOrderDao;

	public ResponseEntity<ResponseStructure<MedItems>> saveMedItems(MedItems medItems, int mid) {
		MedOrder medOrder = mOrderDao.getMedorderById(mid);

		if (medOrder != null) {

			medItems.setMedOrder(medOrder);

			ResponseStructure<MedItems> structure = new ResponseStructure<MedItems>();
			structure.setMessage("saved successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(mDao.saveMeditems(medItems));

			return new ResponseEntity<ResponseStructure<MedItems>>(structure, HttpStatus.CREATED);

		} else
			throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<MedItems>> updateMedItems(MedItems medItems, int mid) {
		MedItems medItems2 = mDao.getMedItemsById(mid);

		if (medItems2 != null) {

			MedOrder medOrder = mOrderDao.getMedorderById(mid);
			medItems.setMedOrder(medOrder);

			ResponseStructure<MedItems> structure = new ResponseStructure<MedItems>();
			structure.setMessage("updated successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(mDao.updateMeditems(medItems, mid));

			return new ResponseEntity<ResponseStructure<MedItems>>(structure, HttpStatus.OK);

		} else
			throw new IdNotFoundException();

	}

	public ResponseEntity<ResponseStructure<MedItems>> deleteMedItems(int id) {

		MedItems medItems = mDao.getMedItemsById(id);

		if (medItems != null) {
			mDao.deleteMedItems(id);

			ResponseStructure<MedItems> structure = new ResponseStructure<MedItems>();
			structure.setMessage("deleted successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(medItems);

			return new ResponseEntity<ResponseStructure<MedItems>>(structure, HttpStatus.OK);

		} else
			throw new IdNotFoundException();

	}

	public ResponseEntity<ResponseStructure<MedItems>> getMeditemsById(int id) {
		MedItems medItems = mDao.getMedItemsById(id);

		if (medItems != null) {
			ResponseStructure<MedItems> structure = new ResponseStructure<MedItems>();
			structure.setMessage("fetched successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(medItems);

			return new ResponseEntity<ResponseStructure<MedItems>>(structure, HttpStatus.OK);

		} else
			throw new IdNotFoundException();

	}

}
