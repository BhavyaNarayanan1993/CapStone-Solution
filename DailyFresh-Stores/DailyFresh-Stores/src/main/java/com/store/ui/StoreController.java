package com.store.ui;

import java.util.List;

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

import com.store.dto.request.StoresAddRequest;
import com.store.dto.request.StoresUpdateRequest;
import com.store.dto.response.StoresAddResponse;
import com.store.dto.response.StoresDeleteResponse;
import com.store.dto.response.StoresModifyResponse;
import com.store.dto.response.StoresSearchResponse;
import com.store.dto.response.StoresShowAllResponse;
import com.store.exception.StoresNotFoundException;
import com.store.model.Stores;
import com.store.service.StoreService;

@RestController
@RequestMapping(value = "/apiStore")
public class StoreController {
	@Autowired
	StoreService service;

	@PostMapping(value = "/add")
	public ResponseEntity<StoresAddResponse> f1(@RequestBody StoresAddRequest request) {

		Stores stores1 = this.service.addNewStore(request.getStores());
		StoresAddResponse response = new StoresAddResponse();
		response.setStatusCode(200);
		response.setDescription("Stores added successfully");
		response.setStores(stores1);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PutMapping(value = "/modify")
	public ResponseEntity<StoresModifyResponse> f2(@RequestBody StoresUpdateRequest request) {
		StoresModifyResponse response = new StoresModifyResponse();
		Stores stores1 = this.service.searchStore(request.getStores());
		if (stores1 != null) {
			Stores stores2 = this.service.updateStore(request.getStores());
			response.setStatusCode(200);
			response.setDescription("Stores modify successfully");
			response.setStores(stores2);
			return ResponseEntity.ok(response);
		} else {
			response.setStatusCode(404);
			response.setDescription("Stores not modify successfully");
			response.setStores(null);
			return new ResponseEntity<StoresModifyResponse>(response, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/find/{sid}")
	public ResponseEntity<StoresSearchResponse> f3(@PathVariable(name = "sid") int sid) throws Exception {
		StoresSearchResponse response = new StoresSearchResponse();
		Stores stores = this.service.searchStore(sid);
		if (stores != null) {
			response.setStatuscode(200);
			response.setDescription("Stores fetched successfully");
			response.setStores(stores);
			return new ResponseEntity<StoresSearchResponse>(response, HttpStatus.OK);
		} else {
			Exception exception = new StoresNotFoundException("Stores not found");
			throw exception;
		}
	}

	@GetMapping(value = "/showAll")
	public ResponseEntity<StoresShowAllResponse> f4() {
		List<Stores> stores = this.service.getAllStores();
		StoresShowAllResponse response = new StoresShowAllResponse();
		response.setStatuscode(200);
		response.setDescription("All Stores fetched");
		response.setStores(stores);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping(value = "/delete")
	public ResponseEntity<StoresDeleteResponse> f5(@RequestBody StoresUpdateRequest request) {
		StoresDeleteResponse response = new StoresDeleteResponse();
		Stores stores = this.service.searchStore(request.getStores());
		if (stores != null) {
			try {

				this.service.deleteStore(request.getStores());
				response.setStatusCode(200);
				response.setDescription("Stores Deleted Successfully");
				response.setDeleteStatus(true);
				return ResponseEntity.ok().body(response);

			} catch (Exception e) {
				response.setStatusCode(500);
				response.setDescription("Stores not Deleted");
				response.setDeleteStatus(false);
				return ResponseEntity.ok().body(response);
			}
		} else {
			response.setStatusCode(404);
			response.setDescription("Stores not Deleted");
			response.setDeleteStatus(false);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}
	
}
