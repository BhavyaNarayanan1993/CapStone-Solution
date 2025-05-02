package com.store.dto.request;

import com.store.model.Stores;

public class StoresUpdateRequest {
	Stores stores;

	public Stores getStores() {
		return stores;
	}

	public void setStores(Stores stores) {
		this.stores = stores;
	}

	@Override
	public String toString() {
		return "StoresUpdateRequest [stores=" + stores + "]";
	}
	
}
