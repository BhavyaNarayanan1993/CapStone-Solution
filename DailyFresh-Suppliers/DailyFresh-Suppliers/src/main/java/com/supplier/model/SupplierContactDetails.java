package com.supplier.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="contacts")
public class SupplierContactDetails {
		
		//@GeneratedValue(strategy = GenerationType.IDENTITY)
		//private String SupplierId;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String contactPersonName;
		private String phoneNumber;
		private String emailId;
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name="id",referencedColumnName = "supplierid")
		private Supplier supplier;
		public SupplierContactDetails(int id, String contactPersonName, String phoneNumber, String emailId,
				Supplier supplier) {
			super();
			this.id = id;
			this.contactPersonName = contactPersonName;
			this.phoneNumber = phoneNumber;
			this.emailId = emailId;
			this.supplier = supplier;
		}
		public SupplierContactDetails() {
			super();
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getContactPersonName() {
			return contactPersonName;
		}
		public void setContactPersonName(String contactPersonName) {
			this.contactPersonName = contactPersonName;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public Supplier getSupplier() {
			return supplier;
		}
		public void setSupplier(Supplier supplier) {
			this.supplier = supplier;
		}
		@Override
		public String toString() {
			return "SupplierContactDetails [id=" + id + ", contactPersonName=" + contactPersonName + ", phoneNumber="
					+ phoneNumber + ", emailId=" + emailId + ", supplier=" + supplier + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!(obj instanceof SupplierContactDetails))
				return false;
			SupplierContactDetails other = (SupplierContactDetails) obj;
			if (id != other.id)
				return false;
			return true;
		}
		
		
		
}
