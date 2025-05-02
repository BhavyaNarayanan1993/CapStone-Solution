package com.customer.dto.customer.response;

import java.util.List;

import com.customer.model.Customer;

public class CustomerShowAllByEmailResponse {

	int statusCode;
	String description;
	List<Customer> customer;
	
	
	
	public List<Customer> getCustomer() {
		return customer;
	}
	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}
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
	@Override
	public String toString() {
		return "CustomerShowAllByCityResponse [statusCode=" + statusCode + ", description=" + description
				+ ", customer=" + customer + "]";
	}
}
