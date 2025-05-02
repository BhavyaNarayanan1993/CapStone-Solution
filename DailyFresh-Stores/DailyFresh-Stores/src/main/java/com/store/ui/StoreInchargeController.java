package com.store.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.store.dto.request.StoreInChargeAddRequest;
import com.store.dto.request.StoreInChargeUpdateRequest;
import com.store.dto.response.StoreInChargeAddResponse;
import com.store.dto.response.StoreInChargeDeleteResponse;
import com.store.dto.response.StoreInChargeModifyResponse;
import com.store.dto.response.StoreInChargeSearchResponse;
import com.store.dto.response.StoreInChargeShowAllResponse;
import com.store.exception.StoresNotFoundException;
import com.store.model.StoreIncharge;
import com.store.service.StoreInChargeService;


@RestController
@RequestMapping(value="/apiStoreInCharge")
public class StoreInchargeController {
	@Autowired
	StoreInChargeService service;

	@PostMapping(value = "/add")
	public ResponseEntity<StoreInChargeAddResponse> f1(@RequestBody StoreInChargeAddRequest request) {

		StoreIncharge storeIncharge1 = this.service.addNewStoreIncharge(request.getStoreIncharge());
		StoreInChargeAddResponse response = new StoreInChargeAddResponse();
		response.setStatusCode(200);
		response.setDescription("StoreInCharge added successfully");
		response.setStoreIncharge(storeIncharge1);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PutMapping(value = "/modify")
	public ResponseEntity<StoreInChargeModifyResponse> f2(@RequestBody StoreInChargeUpdateRequest request) {
		StoreInChargeModifyResponse response = new StoreInChargeModifyResponse();
		StoreIncharge storeIncharge1 = this.service.searchStoreIncharge(request.getStoreIncharge());
		if (storeIncharge1 != null) {
			StoreIncharge storeIncharge2 = this.service.updateStoreIncharge(request.getStoreIncharge());
			response.setStatusCode(200);
			response.setDescription("StoreInCharge modify successfully");
			response.setStoreIncharge(storeIncharge2);
			return ResponseEntity.ok(response);
		} else {
			response.setStatusCode(404);
			response.setDescription("StoreInCharge not modify successfully");
			response.setStoreIncharge(storeIncharge1);
			return new ResponseEntity<StoreInChargeModifyResponse>(response, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/find/{sid}")
	public ResponseEntity<StoreInChargeSearchResponse> f3(@PathVariable(name = "scdid") int scdid) throws Exception {
		StoreInChargeSearchResponse response = new StoreInChargeSearchResponse();
		StoreIncharge storeIncharge = this.service.searchStoreIncharge(scdid);
		if (storeIncharge != null) {
			response.setStatusCode(scdid);
			response.setDescription("StoreInCharge fetched successfully");
			response.setStoreIncharge(storeIncharge);
			return new ResponseEntity<StoreInChargeSearchResponse>(response, HttpStatus.OK);
		} else {
			Exception exception = new StoresNotFoundException("StoreInCharge not found");
			throw exception;
		}
	}

	@GetMapping(value = "/showAll")
	public ResponseEntity<StoreInChargeShowAllResponse> f4() {
		List<StoreIncharge> storeIncharge = this.service.getAllStoreIncharge();
		StoreInChargeShowAllResponse response = new StoreInChargeShowAllResponse();
		response.setStatuscode(200);
		response.setDescription("All StoreInCharge fetched");
		response.setStoreIncharge(storeIncharge);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping(value = "/delete")
	public ResponseEntity<StoreInChargeDeleteResponse> f5(@RequestBody StoreInChargeUpdateRequest request) {
		StoreInChargeDeleteResponse response = new StoreInChargeDeleteResponse();
		StoreIncharge storeIncharge = this.service.searchStoreIncharge(request.getStoreIncharge());
		if (storeIncharge != null) {
			try {

				this.service.deleteStoreIncharge(storeIncharge);
				response.setStatusCode(200);
				response.setDescription("StoreInCharge Deleted Successfully");
				response.setDeleteStatus(true);
				return ResponseEntity.ok().body(response);

			} catch (Exception e) {
				response.setStatusCode(500);
				response.setDescription("StoreInCharge not Deleted");
				response.setDeleteStatus(false);
				return ResponseEntity.ok().body(response);
			}
		} else {
			response.setStatusCode(404);
			response.setDescription("Supplier not Deleted");
			response.setDeleteStatus(false);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}
	
}
