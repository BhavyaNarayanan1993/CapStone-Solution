package com.stock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.db.StockRepository;
import com.stock.model.Stock;

@Service
public class StockService {
	@Autowired
	StockRepository repo;
	
	public Stock addNewStock(Stock stock) {
		return repo.save(stock);
	}
	
	public Stock updateStock(Stock stock) {
		return repo.save(stock);
	}
	
	public Stock searchStock(Stock stock) {
		Optional<Stock> optional=repo.findById(stock.getItemId());
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}
	
	public Stock searchStock(int id) {
		Optional<Stock> optional=repo.findById(id);
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}
	
	public List<Stock> getAllStocks(){
		return repo.findAll();
	}
	
	public boolean deleteStock(Stock stock) {
		repo.delete(stock);
		return true;
	}
	public List<Stock> getStockByLocationId(int locationId) {
		 return this.repo.findByLocationId(locationId);
	}
	
	public List<Stock> getStockByCityId(int cityId) {
		 return this.repo.findByCityId(cityId);
	}
	
	public Optional<Stock> getStockByItemIdAndLocationIdAndCityId(int itemId, int locationId, int cityId){
		return this.repo.findByItemIdAndLocationIdAndCityId(itemId, locationId, cityId);
	}
	
}
