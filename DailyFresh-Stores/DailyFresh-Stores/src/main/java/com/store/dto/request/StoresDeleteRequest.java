package com.store.dto.request;

import com.store.model.Stores;

public class StoresDeleteRequest {
	Stores stores;

	public Stores getStores() {
		return stores;
	}

	public void setStores(Stores stores) {
		this.stores = stores;
	}

	@Override
	public String toString() {
		return "StoresDeleteRequest [stores=" + stores + "]";
	}
	
}
