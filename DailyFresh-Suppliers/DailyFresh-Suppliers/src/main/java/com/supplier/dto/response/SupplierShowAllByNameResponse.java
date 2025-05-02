package com.supplier.dto.response;

import java.util.List;

import com.supplier.model.Supplier;

public class SupplierShowAllByNameResponse {
	int statuscode;
	String description;
	List<Supplier> suppliers;
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
	public List<Supplier> getSuppliers() {
		return suppliers;
	}
	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}
	@Override
	public String toString() {
		return "SupplierShowAllByNameResponse [statuscode=" + statuscode + ", description=" + description
				+ ", suppliers=" + suppliers + "]";
	}
	
	
}
