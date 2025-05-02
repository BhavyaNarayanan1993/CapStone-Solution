package com.customer.dto.customer.response;

import java.util.List;


import com.customer.model.Customer;

public class CustomerAddResponse {

	int statusCode;
	String description;
	 Customer customer;
	public int getStatusCode() {
		return statusCode;
	}
	public String getDescription() {
		return description;
	}
	
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "CustomerAddResponse [statusCode=" + statusCode + ", description=" + description + ", customer="
				+ customer + "]";
	}
	
	
	
	
	
	
}
