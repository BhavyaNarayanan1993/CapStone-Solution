package com.customer.dto.customer.response;

public class CustomerSearchResponse {

	int statusCode;
	String discription;
	boolean searchStatus;
	public int getStatusCode() {
		return statusCode;
	}
	public String getDiscription() {
		return discription;
	}
	public boolean isSearchStatus() {
		return searchStatus;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public void setSearchStatus(boolean searchStatus) {
		this.searchStatus = searchStatus;
	}
	@Override
	public String toString() {
		return "CustomerSearchResponse [statusCode=" + statusCode + ", discription=" + discription + ", searchStatus="
				+ searchStatus + "]";
	}
	
	}
