package com.ty.springboot_hospitalproject.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospitalproject.dto.Encounter;
import com.ty.springboot_hospitalproject.dto.MedOrder;
import com.ty.springboot_hospitalproject.repository.MedorderRepository;

@Repository
public class MedOrderDao {

	@Autowired
	private MedorderRepository repo;

	@Autowired
	private EncounterDao eDao;

	public MedOrder saveMedorder(MedOrder medorder) {

		return repo.save(medorder);

	}

	public MedOrder updateMedOrder(MedOrder medOrder, int mid) {

		if (repo.findById(mid).isPresent()) {

			medOrder.setId(mid);
			return repo.save(medOrder);
		} else
			return null;

	}

	public MedOrder deleteMedorder(int mid) {

		if (repo.findById(mid).isPresent()) {
			MedOrder medOrder = repo.findById(mid).get();
			repo.delete(medOrder);

			return medOrder;

		} else
			return null;

	}

	public MedOrder getMedorderById(int mid) {
		if (repo.findById(mid).isPresent()) {
			return repo.findById(mid).get();

		} else
			return null;

	}

	public List<MedOrder> getAllMedOrderByEncounter(int eid) {

		Encounter encounter = eDao.getById(eid);

		if (encounter != null) {
			return repo.getByEncounter(encounter);

		} else
			return null;
	}

}
