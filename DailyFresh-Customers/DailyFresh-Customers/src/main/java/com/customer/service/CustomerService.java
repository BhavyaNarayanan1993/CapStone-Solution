package com.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.db.CustomerRepository;
import com.customer.model.Customer;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository repo;

	public Customer addNewCustomer(Customer customer) {

		return repo.save(customer);
	}

	public Customer updateCustomer(Customer customer) {

		return repo.save(customer);
	}

	public Customer searchCustomer(Customer customer) {
		Optional<Customer> optional = repo.findById(customer.getCustomerId());
		if (optional.isPresent())
			return optional.get();
		else
			return null;
	}

	public Customer searchCustomer(int id) {
		Optional<Customer> optional = repo.findById(id);
		if (optional.isPresent())
			return optional.get();
		else
			return null;
	}

	public List<Customer> getAllCustomers() {
		return repo.findAll();
	}

	public boolean deleteCustomer(Customer customer) {
		repo.delete(customer);
		return true;
	}

	public List<Customer> getAllCustomerByName(String name) {
		return repo.findByCustomerName(name);
	}

	public List<Customer> getAllCustomersByPhoneNumber(String phoneNumber) {
		return repo.findByCustomerPhoneNumber(phoneNumber);
	}

	public List<Customer> getAllCustomersByEmail(String email) {
		return repo.findByCustomerEmail(email);
	}

	public List<Customer> getCustomerAddress_Location(String location){
		return repo.findByCustomerAddress_Location(location);
	}
	
	public List<Customer> getCustomerAddress_City(String city){
		return repo.findByCustomerAddress_City(city);
	}
}
