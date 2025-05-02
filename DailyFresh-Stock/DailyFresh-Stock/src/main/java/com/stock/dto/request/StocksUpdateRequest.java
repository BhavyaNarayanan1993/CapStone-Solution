package com.stock.dto.request;

import com.stock.model.Stock;

public class StocksUpdateRequest {
	Stock stock;

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "StocksAddRequest [stock=" + stock + "]";
	}
}
