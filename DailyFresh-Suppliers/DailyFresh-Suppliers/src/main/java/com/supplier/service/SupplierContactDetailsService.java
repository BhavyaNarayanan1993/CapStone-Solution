package com.supplier.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supplier.db.SupplierContactDetailsRepository;
import com.supplier.model.SupplierContactDetails;

@Service
public class SupplierContactDetailsService {
	@Autowired
	SupplierContactDetailsRepository repo;
	
	public SupplierContactDetails addNewSupplierContactDetails(SupplierContactDetails supplierContactDetails) {
		return repo.save(supplierContactDetails);
	}
	
	public SupplierContactDetails updateSupplierContactDetails(SupplierContactDetails supplierContactDetails) {
		return repo.save(supplierContactDetails);
	}
	
	public SupplierContactDetails searchSupplierContactDetails(SupplierContactDetails supplierContactDetails) {
		Optional<SupplierContactDetails> optional=repo.findById(supplierContactDetails.getId());
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}
	
	public SupplierContactDetails searchSupplierContactDetails(int id) {
		Optional<SupplierContactDetails> optional=repo.findById(id);
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}
	
	public List<SupplierContactDetails> getAllSupplierContactDetails(){
		return repo.findAll();
	}
	
	public boolean deleteSupplierContactDetails(SupplierContactDetails supplierContactDetails) {
		repo.delete(supplierContactDetails);
		return true;
	}
}
