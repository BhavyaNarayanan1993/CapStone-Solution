package com.supplier.dto.request;

import com.supplier.model.Supplier;

public class SupplierUpdateRequest {
		Supplier supplier;

		public Supplier getSupplier() {
			return supplier;
		}

		public void setSupplier(Supplier supplier) {
			this.supplier = supplier;
		}

		@Override
		public String toString() {
			return "SupplierUpdateRequest [supplier=" + supplier + "]";
		}
			
		
}
