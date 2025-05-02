package com.store.dto.request;

import com.store.model.StoreIncharge;


public class StoreInChargeDeleteRequest {
	StoreIncharge storeIncharge;

	public StoreIncharge getStoreIncharge() {
		return storeIncharge;
	}

	public void setStoreIncharge(StoreIncharge storeIncharge) {
		this.storeIncharge = storeIncharge;
	}

	@Override
	public String toString() {
		return "StoreInChargeDeleteRequest [storeIncharge=" + storeIncharge + "]";
	}
	
}
