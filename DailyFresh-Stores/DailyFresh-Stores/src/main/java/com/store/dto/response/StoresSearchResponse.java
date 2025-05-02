package com.store.dto.response;

import com.store.model.Stores;

public class StoresSearchResponse {
	int statuscode;
	String description;
	Stores stores;
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
	public Stores getStores() {
		return stores;
	}
	public void setStores(Stores stores) {
		this.stores = stores;
	}
	@Override
	public String toString() {
		return "StoresSearchResponse [statuscode=" + statuscode + ", description=" + description + ", stores=" + stores
				+ "]";
	}
	
}
