package com.customer.model;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  customerId;
	@Column
	private String customerName;
	
	@Autowired
	@Column
	private CustomerAddress customerAddress;
	
	@Column
	private String customerEmail;
	
	@Column
	private String customerPhoneNumber;

	public int getCustomerId() {
		return customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public CustomerAddress getCustomerAddress() {
		return customerAddress;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setCustomerAddress(CustomerAddress customerAddress) {
		this.customerAddress = customerAddress;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public Customer(int customerId, String customerName, CustomerAddress customerAddress, String customerEmail,
			String customerPhoneNumber) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerEmail = customerEmail;
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerAddress="
				+ customerAddress + ", customerEmail=" + customerEmail + ", customerPhoneNumber=" + customerPhoneNumber
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Customer))
			return false;
		Customer other = (Customer) obj;
		if (customerId != other.customerId)
			return false;
		return true;
	}
	
	
	
	
	
}
