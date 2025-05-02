package com.stock.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="storeincharges")
public class StoreIncharge {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String name;
		private String phoneNumber;
		
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name="id",referencedColumnName = "storeid")
		private Stores stores;

		public StoreIncharge(int id, String name, String phoneNumber, Stores stores) {
			super();
			this.id = id;
			this.name = name;
			this.phoneNumber = phoneNumber;
			this.stores = stores;
		}

		public StoreIncharge() {
			super();
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public Stores getStores() {
			return stores;
		}

		public void setStores(Stores stores) {
			this.stores = stores;
		}

		@Override
		public String toString() {
			return "StoreIncharge [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", stores=" + stores
					+ "]";
		}
		
		
}
