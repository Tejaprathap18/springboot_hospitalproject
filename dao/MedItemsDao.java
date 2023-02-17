package com.ty.springboot_hospitalproject.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospitalproject.dto.MedItems;
import com.ty.springboot_hospitalproject.repository.MedItemsRepository;

@Repository
public class MedItemsDao {

	@Autowired
	private MedItemsRepository repo;

	public MedItems saveMeditems(MedItems medItems) {

		return repo.save(medItems);

	}

	public MedItems updateMeditems(MedItems medItems, int id) {

		if (repo.findById(id).isPresent()) {

			medItems.setId(id);
			return repo.save(medItems);
		} else
			return null;

	}

	public MedItems getMedItemsById(int id) {
		if (repo.findById(id).isPresent()) {

			return repo.findById(id).get();

		} else
			return null;

	}
	public MedItems deleteMedItems(int id) {
		
		MedItems medItems=repo.findById(id).get();
		
		if (repo.findById(id).isPresent()) {

			repo.delete(medItems);
			
			return medItems;

		} else
			return null;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
