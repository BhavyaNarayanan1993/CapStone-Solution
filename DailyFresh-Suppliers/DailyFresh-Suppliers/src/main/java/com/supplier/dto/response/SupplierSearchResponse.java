package com.supplier.dto.response;

import com.supplier.model.Supplier;

public class SupplierSearchResponse {
	int statuscode;
	String description;
	Supplier supplier;
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
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	@Override
	public String toString() {
		return "SupplierSearchResponse [statuscode=" + statuscode + ", description=" + description + ", supplier="
				+ supplier + "]";
	}
	
	
	
}
