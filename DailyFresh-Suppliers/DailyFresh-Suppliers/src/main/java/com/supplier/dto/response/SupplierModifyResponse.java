package com.supplier.dto.response;

import com.supplier.model.Supplier;

public class SupplierModifyResponse {
	int statusCode;
	String description;
	Supplier supplier;
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
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	@Override
	public String toString() {
		return "SupplierModifyResponse [statusCode=" + statusCode + ", description=" + description + ", supplier="
				+ supplier + "]";
	}
	
	
	
}
