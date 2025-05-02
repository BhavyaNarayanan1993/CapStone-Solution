package com.stock.db;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer>{
	
	 List<Stock> findByLocationId(int locationId);

	 List<Stock> findByCityId(int cityId);
	 
	 Optional<Stock> findByItemIdAndLocationIdAndCityId(int itemId, int locationId, int cityId);
}
