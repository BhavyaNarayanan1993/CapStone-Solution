package com.customer.db;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

    List<Customer> findByCustomerName(String customerName);
	
	List<Customer> findByCustomerPhoneNumber(String customerPhoneNumber);
	
	List<Customer> findByCustomerEmail(String customerEmail);
	
	List<Customer> findByCustomerAddress_Location(String location);
	
	List<Customer> findByCustomerAddress_City(String city);
}
