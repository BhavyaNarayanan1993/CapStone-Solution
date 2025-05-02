package com.store.dto.response;

import java.util.List;

import com.stock.model.Stock;

public class StockShowAllByCityResponse {
	
	int statuscode;
	String description;
	List<Stock> stocks;
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
	public List<Stock> getStocks() {
		return stocks;
	}
	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
	@Override
	public String toString() {
		return "StockShowAllByCityResponse [statuscode=" + statuscode + ", description=" + description + ", stocks="
				+ stocks + "]";
	}
	
}
