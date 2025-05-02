package com.store.dto.response;

public class ErrorResponse {
		int status;
		String errorMessage;
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		public String getErrorMessage() {
			return errorMessage;
		}
		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}
		@Override
		public String toString() {
			return "ErrorResponse [status=" + status + ", errorMessage=" + errorMessage + "]";
		}
		
}
