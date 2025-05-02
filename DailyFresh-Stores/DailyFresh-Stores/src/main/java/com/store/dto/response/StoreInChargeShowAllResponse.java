package com.store.dto.response;

import java.util.List;

import com.store.model.StoreIncharge;

public class StoreInChargeShowAllResponse {
	int statuscode;
	String description;
	List<StoreIncharge>  storeIncharge;
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
	public List<StoreIncharge> getStoreIncharge() {
		return storeIncharge;
	}
	public void setStoreIncharge(List<StoreIncharge> storeIncharge) {
		this.storeIncharge = storeIncharge;
	}
	@Override
	public String toString() {
		return "StoreInChargeShowAllResponse [statuscode=" + statuscode + ", description=" + description
				+ ", storeIncharge=" + storeIncharge + "]";
	}
	
}
