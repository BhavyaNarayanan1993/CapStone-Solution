package com.stock.ui;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stock.dto.request.StockUpdateByItemLocationCityRequest;
import com.stock.dto.request.StocksAddRequest;
import com.stock.dto.request.StocksUpdateRequest;
import com.stock.exception.StocksNotFoundException;
import com.stock.model.Stock;
import com.stock.service.StockService;
import com.store.dto.response.StockShowAllByCityResponse;
import com.store.dto.response.StockShowAllByLocationResponse;
import com.store.dto.response.StockUpdateByItemLocationCityResponse;
import com.store.dto.response.StocksAddResponse;
import com.store.dto.response.StocksDeleteResponse;
import com.store.dto.response.StocksModifyResponse;
import com.store.dto.response.StocksSearchResponse;
import com.store.dto.response.StocksShowAllResponse;

@RestController
@RequestMapping(value = "/apiStock")
public class StockController {
	@Autowired
	StockService service;

	@PostMapping(value = "/add")
	public ResponseEntity<StocksAddResponse> f1(@RequestBody StocksAddRequest request) {

		Stock stock1 = this.service.addNewStock(request.getStock());
		StocksAddResponse response = new StocksAddResponse();
		response.setStatusCode(200);
		response.setDescription("Stocks added successfully");
		response.setStock(stock1);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PutMapping(value = "/modify")
	public ResponseEntity<StocksModifyResponse> f2(@RequestBody StocksUpdateRequest request) {
		StocksModifyResponse response = new StocksModifyResponse();
		Stock stock1 = this.service.searchStock(request.getStock());
		if (stock1 != null) {
			Stock stock2 = this.service.updateStock(request.getStock());
			response.setStatusCode(200);
			response.setDescription("Stocks modify successfully");
			response.setStock(stock2);
			return ResponseEntity.ok(response);
		} else {
			response.setStatusCode(404);
			response.setDescription("Stocks not modify successfully");
			response.setStock(null);
			return new ResponseEntity<StocksModifyResponse>(response, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/find/{sid}")
	public ResponseEntity<StocksSearchResponse> f3(@PathVariable(name = "sid") int sid) throws Exception {
		StocksSearchResponse response = new StocksSearchResponse();
		Stock stock = this.service.searchStock(sid);
		if (stock != null) {
			response.setStatusCode(200);
			response.setDescription("Stocks fetched successfully");
			response.setStock(stock);
			return new ResponseEntity<StocksSearchResponse>(response, HttpStatus.OK);
		} else {
			Exception exception = new StocksNotFoundException("Stocks not found");
			throw exception;
		}
	}

	@GetMapping(value = "/showAll")
	public ResponseEntity<StocksShowAllResponse> f4() {
		List<Stock> stock = this.service.getAllStocks();
		StocksShowAllResponse response = new StocksShowAllResponse();
		response.setStatuscode(200);
		response.setDescription("All Stocks fetched");
		response.setStock(stock);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping(value = "/delete")
	public ResponseEntity<StocksDeleteResponse> f5(@RequestBody StocksUpdateRequest request) {
		StocksDeleteResponse response = new StocksDeleteResponse();
		Stock stock = this.service.searchStock(request.getStock());
		if (stock != null) {
			try {

				this.service.deleteStock(request.getStock());
				response.setStatusCode(200);
				response.setDescription("Stocks Deleted Successfully");
				response.setDeleteStatus(true);
				return ResponseEntity.ok().body(response);

			} catch (Exception e) {
				response.setStatusCode(500);
				response.setDescription("Stocks not Deleted");
				response.setDeleteStatus(false);
				return ResponseEntity.ok().body(response);
			}
		} else {
			response.setStatusCode(404);
			response.setDescription("Stocks not Deleted");
			response.setDeleteStatus(false);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping("/showAllByLocationId")
	public ResponseEntity<StockShowAllByLocationResponse> f6(@RequestParam(name="txt_locationId") int locationId){
		StockShowAllByLocationResponse response=new StockShowAllByLocationResponse();
		List<Stock> stockByLocation=this.service.getStockByLocationId(locationId);
		if(stockByLocation.isEmpty()) {
			response.setStatuscode(200);
			response.setDescription("There are no Stocks by same name "+locationId);
			response.setStocks(stockByLocation);
		}
		else
		{
			response.setStatuscode(200);
			response.setDescription("There are "+stockByLocation.size()+" with same Location ");
			response.setStocks(stockByLocation);
		}
		return ResponseEntity.ok(response);
	}
	@GetMapping("/showAllByCityId")
	public ResponseEntity<StockShowAllByCityResponse> f7(@RequestParam(name="txt_cityd") int cityId){
		StockShowAllByCityResponse response=new StockShowAllByCityResponse();
		List<Stock> stockByCity=this.service.getStockByCityId(cityId);
		if(stockByCity.isEmpty()) {
			response.setStatuscode(200);
			response.setDescription("There are no Stocks by same name "+cityId);
			response.setStocks(stockByCity);
		}
		else
		{
			response.setStatuscode(200);
			response.setDescription("There are "+stockByCity.size()+" with same city ");
			response.setStocks(stockByCity);
		}
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/modifyByItemCityLocation")
	public ResponseEntity<StockUpdateByItemLocationCityResponse> f8(@RequestBody StockUpdateByItemLocationCityRequest request){
		StockUpdateByItemLocationCityResponse response = new StockUpdateByItemLocationCityResponse();
		Stock stock1 = this.service.searchStock(request.getCityId());
		if (stock1 != null) {
			Optional<Stock> stock2 = this.service.getStockByItemIdAndLocationIdAndCityId(request.getItemId(), request.getToLocationId(), request.getCityId());
			response.setStatusCode(200);
			response.setDescription("Stocks modify successfully");
			response.setStock(stock2);
			return ResponseEntity.ok(response);
		} else {
			response.setStatusCode(404);
			response.setDescription("Stocks not modify successfully");
			response.setStock(null);
			return new ResponseEntity<StockUpdateByItemLocationCityResponse>(response, HttpStatus.OK);
		}
	}
}
