package com.stock.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="stocks")
public class Stock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int	itemId;
	private int locationId;
	@JoinColumn(name="cityid",referencedColumnName = "cityid")
	private int cityId;
	private double availableQuantity;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public double getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(double availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	@Override
	public String toString() {
		return "Stock [itemId=" + itemId + ", locationId=" + locationId + ", cityId=" + cityId + ", availableQuantity="
				+ availableQuantity + "]";
	}

	
}
