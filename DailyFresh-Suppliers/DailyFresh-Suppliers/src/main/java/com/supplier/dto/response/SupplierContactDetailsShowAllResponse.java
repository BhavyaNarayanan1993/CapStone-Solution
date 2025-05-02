package com.supplier.dto.response;

import java.util.List;

import com.supplier.model.SupplierContactDetails;


public class SupplierContactDetailsShowAllResponse {
	int statuscode;
	String description;
	List<SupplierContactDetails> supplierContactDetails;
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
	public List<SupplierContactDetails> getSupplierContactDetails() {
		return supplierContactDetails;
	}
	public void setSupplierContactDetails(List<SupplierContactDetails> supplierContactDetails2) {
		this.supplierContactDetails = supplierContactDetails2;
	}
	@Override
	public String toString() {
		return "SupplierContactDetailsShowAllResponse [statuscode=" + statuscode + ", description=" + description
				+ ", supplierContactDetails=" + supplierContactDetails + "]";
	}
	
	
	
}
