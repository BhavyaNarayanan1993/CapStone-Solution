package com.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.db.StoreRepository;
import com.store.model.Stores;

@Service
public class StoreService {
	@Autowired
	StoreRepository repo;
	
	public Stores addNewStore(Stores store) {
		return repo.save(store);
	}
	
	public Stores updateStore(Stores store) {
		return repo.save(store);
	}
	
	public Stores searchStore(Stores store) {
		Optional<Stores> optional=repo.findById(store.getStoreId());
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}
	
	public Stores searchStore(int id) {
		Optional<Stores> optional=repo.findById(id);
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}
	
	public List<Stores> getAllStores(){
		return repo.findAll();
	}
	
	public boolean deleteStore(Stores store) {
		repo.delete(store);
		return true;
	}
	
	
}
