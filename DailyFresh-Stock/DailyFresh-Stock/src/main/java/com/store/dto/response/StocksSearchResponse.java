package com.store.dto.response;

import com.stock.model.Stock;

public class StocksSearchResponse {
	int statusCode;
	String description;
	Stock stock;
	
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
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "StocksSearchResponse [statusCode=" + statusCode + ", description=" + description + ", stock=" + stock
				+ "]";
	}
}
