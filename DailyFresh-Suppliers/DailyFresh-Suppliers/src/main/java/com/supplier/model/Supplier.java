package com.supplier.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="suppliers")
public class Supplier {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private  int supplierId;
		
		private String supplierName;
		private String supplierCity;
		@OneToOne(cascade =CascadeType.ALL)
		SupplierContactDetails supplierContactDetails;
		public Supplier(int supplierId, String supplierName, String supplierCity,
				SupplierContactDetails supplierContactDetails) {
			super();
			this.supplierId = supplierId;
			this.supplierName = supplierName;
			this.supplierCity = supplierCity;
			this.supplierContactDetails = supplierContactDetails;
		}
		public Supplier() {
			super();
		}
		public int getSupplierId() {
			return supplierId;
		}
		public void setSupplierId(int supplierId) {
			this.supplierId = supplierId;
		}
		public String getSupplierName() {
			return supplierName;
		}
		public void setSupplierName(String supplierName) {
			this.supplierName = supplierName;
		}
		public String getSupplierCity() {
			return supplierCity;
		}
		public void setSupplierCity(String supplierCity) {
			this.supplierCity = supplierCity;
		}
		public SupplierContactDetails getSupplierContactDetails() {
			return supplierContactDetails;
		}
		public void setSupplierContactDetails(SupplierContactDetails supplierContactDetails) {
			this.supplierContactDetails = supplierContactDetails;
		}
		@Override
		public String toString() {
			return "Supplier [supplierId=" + supplierId + ", supplierName=" + supplierName + ", supplierCity="
					+ supplierCity + ", supplierContactDetails=" + supplierContactDetails + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + supplierId;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!(obj instanceof Supplier))
				return false;
			Supplier other = (Supplier) obj;
			if (supplierId != other.supplierId)
				return false;
			return true;
		}
		
}
