package com.customer.dto.customer.response;

public class ErrorResponse {

	int statusCode;
	String errorMessage;
	public int getStatusCode() {
		return statusCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	@Override
	public String toString() {
		return "ErrorResponse [statusCode=" + statusCode + ", errorMessage=" + errorMessage + "]";
	}
	
	
	
}
