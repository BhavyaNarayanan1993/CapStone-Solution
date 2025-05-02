package com.store.dto.response;

public class StoresDeleteResponse {
	int statusCode;
	String description;
	boolean deleteStatus;
	
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
	public boolean isDeleteStatus() {
		return deleteStatus;
	}
	public void setDeleteStatus(boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}
	@Override
	public String toString() {
		return "SupplierDeleteResponse [statusCode=" + statusCode + ", description=" + description + ", deleteStatus="
				+ deleteStatus + "]";
	}
	
	
}
