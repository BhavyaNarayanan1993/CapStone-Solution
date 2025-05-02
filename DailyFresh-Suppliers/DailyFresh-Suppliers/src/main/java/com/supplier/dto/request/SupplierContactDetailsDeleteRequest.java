package com.supplier.dto.request;

import com.supplier.model.SupplierContactDetails;

public class SupplierContactDetailsDeleteRequest {
	SupplierContactDetails supplierContactDetails;

	public SupplierContactDetails getSupplierContactDetails() {
		return supplierContactDetails;
	}

	public void setSupplierContactDetails(SupplierContactDetails invoice) {
		this.supplierContactDetails = supplierContactDetails;
	}

	@Override
	public String toString() {
		return "SupplierContactDetailsDeleteRequest [supplierContactDetails=" + supplierContactDetails + "]";
	}

	
	
	
}
