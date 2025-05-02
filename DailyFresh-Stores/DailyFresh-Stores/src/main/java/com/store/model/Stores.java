package com.store.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="stores")
public class Stores {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int storeId;
	private String storeAddress;
	@JoinColumn(name="cityid",referencedColumnName = "cityid")
	private int cityId;
	@OneToOne(cascade =CascadeType.ALL)
	StoreIncharge storeincharge;
	public Stores(int storeId, String storeAddress, int cityId, StoreIncharge storeincharge) {
		super();
		this.storeId = storeId;
		this.storeAddress = storeAddress;
		this.cityId = cityId;
		this.storeincharge = storeincharge;
	}
	public Stores() {
		super();
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getStoreAddress() {
		return storeAddress;
	}
	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public StoreIncharge getStoreincharge() {
		return storeincharge;
	}
	public void setStoreincharge(StoreIncharge storeincharge) {
		this.storeincharge = storeincharge;
	}
	@Override
	public String toString() {
		return "Stores [storeId=" + storeId + ", storeAddress=" + storeAddress + ", cityId=" + cityId
				+ ", storeincharge=" + storeincharge + "]";
	}
	
	
}
