package com.bills.dto.response;

import com.bills.model.Bill;

public class BillsAddResponse {
	int statusCode;
	String description;
	Bill bills;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Bill getBills() {
		return bills;
	}
	public void setBills(Bill bills) {
		this.bills = bills;
	}
	@Override
	public String toString() {
		return "BillsAddResponse [statusCode=" + statusCode + ", description=" + description + ", bills=" + bills + "]";
	}
	
}
