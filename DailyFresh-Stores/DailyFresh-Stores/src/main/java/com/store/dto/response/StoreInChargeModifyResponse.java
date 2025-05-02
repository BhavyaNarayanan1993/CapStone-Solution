package com.store.dto.response;

import com.store.model.StoreIncharge;

public class StoreInChargeModifyResponse {
		
	int statusCode;
	String description;
	StoreIncharge storeIncharge;
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
	public StoreIncharge getStoreIncharge() {
		return storeIncharge;
	}
	public void setStoreIncharge(StoreIncharge storeIncharge) {
		this.storeIncharge = storeIncharge;
	}
	@Override
	public String toString() {
		return "StoreInChargeModifyResponse [statusCode=" + statusCode + ", description=" + description
				+ ", storeIncharge=" + storeIncharge + "]";
	}
	
}
