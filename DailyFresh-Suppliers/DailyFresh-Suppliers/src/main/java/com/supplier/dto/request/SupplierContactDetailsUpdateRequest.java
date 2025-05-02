package com.supplier.dto.request;

import com.supplier.model.SupplierContactDetails;

public class SupplierContactDetailsUpdateRequest {
	SupplierContactDetails supplierContactDetails;

	public SupplierContactDetails getSupplierContactDetails() {
		return supplierContactDetails;
	}

	public void setSupplierContactDetails(SupplierContactDetails supplierContactDetails) {
		this.supplierContactDetails = supplierContactDetails;
	}

	@Override
	public String toString() {
		return "SupplierContactDetailsUpdateRequest [supplierContactDetails=" + supplierContactDetails + "]";
	}

	
	
	
}
