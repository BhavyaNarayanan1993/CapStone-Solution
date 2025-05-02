package com.bills.dto.response;

import java.util.List;

import com.bills.model.Bill;


public class BillsShowAllResponse {
	int statuscode;
	String description;
	List<Bill> bills;
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Bill> getBills() {
		return bills;
	}
	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}
	@Override
	public String toString() {
		return "BillsShowAllResponse [statuscode=" + statuscode + ", description=" + description + ", bills=" + bills
				+ "]";
	}
	
	
		
}
