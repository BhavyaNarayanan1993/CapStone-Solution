package com.bills.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class CustomerAddress {

private String location;
	
	
	private String city;

	public String getLocation() {
		return location;
	}

	public String getCity() {
		return city;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	
	public CustomerAddress() {
		super();
	}

	public CustomerAddress(String location, String city) {
		super();
		this.location = location;
		this.city = city;
	}

	@Override
	public String toString() {
		return "CustomerAddress [location=" + location + ", city=" + city + "]";
	}
	
	
}
