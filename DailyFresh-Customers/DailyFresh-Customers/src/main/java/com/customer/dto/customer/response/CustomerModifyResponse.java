package com.customer.dto.customer.response;

import com.customer.model.Customer;

public class CustomerModifyResponse {

	int statusCode;
	String description;
	Customer customer;
	public int getStatusCode() {
		return statusCode;
	}
	public String getDescription() {
		return description;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "CustomerModifyResponse [statusCode=" + statusCode + ", description=" + description + ", customer="
				+ customer + "]";
	}
	
	
}
