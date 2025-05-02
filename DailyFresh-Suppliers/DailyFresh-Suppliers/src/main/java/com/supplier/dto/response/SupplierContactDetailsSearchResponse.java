package com.supplier.dto.response;

import com.supplier.model.SupplierContactDetails;

public class SupplierContactDetailsSearchResponse {
	int statusCode;
	String description;
	SupplierContactDetails supplierContactDetails;
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
	public SupplierContactDetails getSupplierContactDetails() {
		return supplierContactDetails;
	}
	public void setSupplierContactDetails(SupplierContactDetails supplierContactDetails) {
		this.supplierContactDetails = supplierContactDetails;
	}
	@Override
	public String toString() {
		return "SupplierContactDetailsSearchResponse [statusCode=" + statusCode + ", description=" + description
				+ ", supplierContactDetails=" + supplierContactDetails + "]";
	}
	
	
}
