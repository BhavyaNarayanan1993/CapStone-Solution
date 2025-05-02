package com.store.dto.response;

import com.store.model.Stores;

public class StoresModifyResponse {
	int statusCode;
	String description;
	Stores stores;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
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
		return "StoresModifyResponse [statusCode=" + statusCode + ", description=" + description + ", stores=" + stores
				+ "]";
	}
	
}
