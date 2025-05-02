package com.supplier.dto.request;

import com.supplier.model.SupplierContactDetails;

public class SupplierContactDetailsAddRequest {
		SupplierContactDetails supplierContactDetails;

		public SupplierContactDetails getSupplierContactDetails() {
			return supplierContactDetails;
		}

		public void setInvoice(SupplierContactDetails supplierContactDetails) {
			this.supplierContactDetails = supplierContactDetails;
		}

		@Override
		public String toString() {
			return "SupplierContactDetailsAddRequest [supplierContactDetails=" + supplierContactDetails + "]";
		}

		
		
}
