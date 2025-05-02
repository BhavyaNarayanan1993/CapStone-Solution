package com.store.dto.response;

import java.util.Optional;

import com.stock.model.Stock;

public class StockUpdateByItemLocationCityResponse {
	int statusCode;
	String description;
	Optional<Stock> stock;
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
	public Optional<Stock> getStock() {
		return stock;
	}
	public void setStock(Optional<Stock> stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "StockUpdateByItemLocationCityResponse [statusCode=" + statusCode + ", description=" + description
				+ ", stock=" + stock + "]";
	}
	
	
	
}
