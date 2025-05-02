package com.store.dto.response;

import java.util.List;

import com.stock.model.Stock;

public class StocksShowAllResponse {
	int statuscode;
	String description;
	List<Stock> stock;
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Stock> getStock() {
		return stock;
	}
	public void setStock(List<Stock> stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "StocksShowAllResponse [statuscode=" + statuscode + ", description=" + description + ", stock=" + stock
				+ "]";
	}
	
		
}
