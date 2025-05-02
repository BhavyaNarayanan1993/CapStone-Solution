package com.bills.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bills.db.BillsRepository;
import com.bills.model.Bill;

@Service
public class BillsService {
	@Autowired
	BillsRepository repo;
	
	public Bill addNewBill(Bill bill) {
		return repo.save(bill);
	}
	
	public Bill updateBill(Bill bill) {
		return repo.save(bill);
	}
	
	public Bill searchBill(Bill bill) {
		Optional<Bill> optional=repo.findById(bill.getBillNumber());
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}
	
	public Bill searchBill(int id) {
		Optional<Bill> optional=repo.findById(id);
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}
	
	public List<Bill> getAllBills(){
		return repo.findAll();
	}
	
	public boolean deleteBill(Bill bill) {
		repo.delete(bill);
		return true;
	}
	
	
}
