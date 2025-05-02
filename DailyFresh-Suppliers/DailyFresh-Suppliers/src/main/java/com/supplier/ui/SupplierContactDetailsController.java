package com.supplier.ui;

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

import com.supplier.dto.request.SupplierContactDetailsAddRequest;
import com.supplier.dto.request.SupplierContactDetailsUpdateRequest;
import com.supplier.dto.response.SupplierContactDetailsAddResponse;
import com.supplier.dto.response.SupplierContactDetailsDeleteResponse;
import com.supplier.dto.response.SupplierContactDetailsModifyResponse;
import com.supplier.dto.response.SupplierContactDetailsSearchResponse;
import com.supplier.dto.response.SupplierContactDetailsShowAllResponse;
import com.supplier.exception.SupplierNotFoundException;
import com.supplier.model.Supplier;
import com.supplier.model.SupplierContactDetails;
import com.supplier.service.SupplierContactDetailsService;
import com.supplier.service.SupplierService;

@RestController
@RequestMapping(value="/apiSupplierContact")
public class SupplierContactDetailsController {
	@Autowired
	SupplierContactDetailsService service;

	@PostMapping(value = "/add")
	public ResponseEntity<SupplierContactDetailsAddResponse> f1(@RequestBody SupplierContactDetailsAddRequest request) {

		SupplierContactDetails supplierContactDetails1 = this.service.addNewSupplierContactDetails(request.getSupplierContactDetails());
		SupplierContactDetailsAddResponse response = new SupplierContactDetailsAddResponse();
		response.setStatusCode(200);
		response.setDescription("Suppliers added successfully");
		response.setSupplierContactDetails(supplierContactDetails1);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PutMapping(value = "/modify")
	public ResponseEntity<SupplierContactDetailsModifyResponse> f2(@RequestBody SupplierContactDetailsUpdateRequest request) {
		SupplierContactDetailsModifyResponse response = new SupplierContactDetailsModifyResponse();
		SupplierContactDetails supplierContactDetails1 = this.service.searchSupplierContactDetails(request.getSupplierContactDetails());
		if (supplierContactDetails1 != null) {
			SupplierContactDetails supplierContactDetails2 = this.service.updateSupplierContactDetails(request.getSupplierContactDetails());
			response.setStatusCode(200);
			response.setDescription("Suppliers modify successfully");
			response.setSupplierContactDetails(supplierContactDetails1);
			return ResponseEntity.ok(response);
		} else {
			response.setStatusCode(404);
			response.setDescription("Suppliers not modify successfully");
			response.setSupplierContactDetails(supplierContactDetails1);
			return new ResponseEntity<SupplierContactDetailsModifyResponse>(response, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/find/{sid}")
	public ResponseEntity<SupplierContactDetailsSearchResponse> f3(@PathVariable(name = "scdid") int scdid) throws Exception {
		SupplierContactDetailsSearchResponse response = new SupplierContactDetailsSearchResponse();
		SupplierContactDetails supplierContactDetails = this.service.searchSupplierContactDetails(scdid);
		if (supplierContactDetails != null) {
			response.setStatusCode(scdid);
			response.setDescription("Suppliers fetched successfully");
			response.setSupplierContactDetails(supplierContactDetails);
			return new ResponseEntity<SupplierContactDetailsSearchResponse>(response, HttpStatus.OK);
		} else {
			Exception exception = new SupplierNotFoundException("Supplier not found");
			throw exception;
		}
	}

	@GetMapping(value = "/showAll")
	public ResponseEntity<SupplierContactDetailsShowAllResponse> f4() {
		List<SupplierContactDetails> supplierContactDetails = this.service.getAllSupplierContactDetails();
		SupplierContactDetailsShowAllResponse response = new SupplierContactDetailsShowAllResponse();
		response.setStatuscode(200);
		response.setDescription("All Suppliers fetched");
		response.setSupplierContactDetails(supplierContactDetails);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping(value = "/delete")
	public ResponseEntity<SupplierContactDetailsDeleteResponse> f5(@RequestBody SupplierContactDetailsUpdateRequest request) {
		SupplierContactDetailsDeleteResponse response = new SupplierContactDetailsDeleteResponse();
		SupplierContactDetails supplierContactDetails = this.service.searchSupplierContactDetails(request.getSupplierContactDetails());
		if (supplierContactDetails != null) {
			try {

				this.service.deleteSupplierContactDetails(supplierContactDetails);
				response.setStatusCode(200);
				response.setDescription("Supplier Deleted Successfully");
				response.setDeleteStatus(true);
				return ResponseEntity.ok().body(response);

			} catch (Exception e) {
				response.setStatusCode(500);
				response.setDescription("Supplier not Deleted");
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
