package com.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.db.StoreInchargeRepository;
import com.store.model.StoreIncharge;

@Service
public class StoreInChargeService {
	@Autowired
	StoreInchargeRepository repo;
	
	public StoreIncharge addNewStoreIncharge(StoreIncharge storeIncharge) {
		return repo.save(storeIncharge);
	}
	
	public StoreIncharge updateStoreIncharge(StoreIncharge storeIncharge) {
		return repo.save(storeIncharge);
	}
	
	public StoreIncharge searchStoreIncharge(StoreIncharge storeIncharge) {
		Optional<StoreIncharge> optional=repo.findById(storeIncharge.getId());
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}
	
	public StoreIncharge searchStoreIncharge(int id) {
		Optional<StoreIncharge> optional=repo.findById(id);
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}
	
	public List<StoreIncharge> getAllStoreIncharge(){
		return repo.findAll();
	}
	
	public boolean deleteStoreIncharge(StoreIncharge storeIncharge) {
		repo.delete(storeIncharge);
		return true;
	}
}
