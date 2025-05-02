package com.store.dto.response;

import java.util.List;

import com.store.model.Stores;

public class StoresShowAllResponse {
	int statuscode;
	String description;
	List<Stores> stores;
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
	public List<Stores> getStores() {
		return stores;
	}
	public void setStores(List<Stores> stores) {
		this.stores = stores;
	}
	@Override
	public String toString() {
		return "StoresShowAllResponse [statuscode=" + statuscode + ", description=" + description + ", stores=" + stores
				+ "]";
	}
	
		
}
