package com.supplier.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supplier.db.SupplierRepository;
import com.supplier.model.Supplier;

@Service
public class SupplierService {
	@Autowired
	SupplierRepository repo;
	
	public Supplier addNewSupplier(Supplier supplier) {
		return repo.save(supplier);
	}
	
	public Supplier updateSupplier(Supplier supplier) {
		return repo.save(supplier);
	}
	
	public Supplier searchSupplier(Supplier supplier) {
		Optional<Supplier> optional=repo.findById(supplier.getSupplierId());
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}
	
	public Supplier searchSupplier(int id) {
		Optional<Supplier> optional=repo.findById(id);
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}
	
	public List<Supplier> getAllSuppliers(){
		return repo.findAll();
	}
	
	public boolean deleteSupplier(Supplier supplier) {
		repo.delete(supplier);
		return true;
	}
	
	public List<Supplier> getSuppliersByName(String name){
		return repo.findBySupplierName(name);
	}
	
	public List<Supplier> getSuppliersByCity(String city){
		return repo.findBySupplierCity(city);
	}
}
