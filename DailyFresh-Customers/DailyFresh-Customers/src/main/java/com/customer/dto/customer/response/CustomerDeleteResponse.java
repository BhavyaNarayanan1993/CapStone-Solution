package com.customer.dto.customer.response;

public class CustomerDeleteResponse {

	int statusCode;
	String discription;
	boolean deleteStatus;
	public int getStatusCode() {
		return statusCode;
	}
	public String getDiscription() {
		return discription;
	}
	public boolean isDeleteStatus() {
		return deleteStatus;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public void setDeleteStatus(boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}
	@Override
	public String toString() {
		return "CustomerDeleteResponse [statusCode=" + statusCode + ", discription=" + discription + ", deleteStatus="
				+ deleteStatus + "]";
	}
}
