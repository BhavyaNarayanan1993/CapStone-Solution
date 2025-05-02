package com.supplier.ui;

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

import com.supplier.dto.request.SupplierAddRequest;
import com.supplier.dto.request.SupplierUpdateRequest;
import com.supplier.dto.response.SupplierAddResponse;
import com.supplier.dto.response.SupplierDeleteResponse;
import com.supplier.dto.response.SupplierModifyResponse;
import com.supplier.dto.response.SupplierSearchResponse;
import com.supplier.dto.response.SupplierShowAllByCityResponse;
import com.supplier.dto.response.SupplierShowAllByNameResponse;
import com.supplier.dto.response.SupplierShowAllResponse;
import com.supplier.exception.SupplierNotFoundException;
import com.supplier.model.Supplier;
import com.supplier.service.SupplierService;

@RestController
@RequestMapping(value = "/apiSupplier")
public class SupplierController {
	@Autowired
	SupplierService service;

	@PostMapping(value = "/add")
	public ResponseEntity<SupplierAddResponse> f1(@RequestBody SupplierAddRequest request) {

		Supplier supplier1 = this.service.addNewSupplier(request.getSupplier());
		SupplierAddResponse response = new SupplierAddResponse();
		response.setStatusCode(200);
		response.setDescription("Suppliers added successfully");
		response.setSupplier(supplier1);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PutMapping(value = "/modify")
	public ResponseEntity<SupplierModifyResponse> f2(@RequestBody SupplierUpdateRequest request) {
		SupplierModifyResponse response = new SupplierModifyResponse();
		Supplier supplier1 = this.service.searchSupplier(request.getSupplier());
		if (supplier1 != null) {
			Supplier supplier2 = this.service.updateSupplier(request.getSupplier());
			response.setStatusCode(200);
			response.setDescription("Suppliers modify successfully");
			response.setSupplier(supplier2);
			return ResponseEntity.ok(response);
		} else {
			response.setStatusCode(404);
			response.setDescription("Suppliers not modify successfully");
			response.setSupplier(null);
			return new ResponseEntity<SupplierModifyResponse>(response, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/find/{sid}")
	public ResponseEntity<SupplierSearchResponse> f3(@PathVariable(name = "sid") int sid) throws Exception {
		SupplierSearchResponse response = new SupplierSearchResponse();
		Supplier supplier = this.service.searchSupplier(sid);
		if (supplier != null) {
			response.setStatuscode(200);
			response.setDescription("Suppliers fetched successfully");
			response.setSupplier(supplier);
			return new ResponseEntity<SupplierSearchResponse>(response, HttpStatus.OK);
		} else {
			Exception exception = new SupplierNotFoundException("Supplier not found");
			throw exception;
		}
	}

	@GetMapping(value = "/showAll")
	public ResponseEntity<SupplierShowAllResponse> f4() {
		List<Supplier> suppliers = this.service.getAllSuppliers();
		SupplierShowAllResponse response = new SupplierShowAllResponse();
		response.setStatuscode(200);
		response.setDescription("All Suppliers fetched");
		response.setSuppliers(suppliers);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping(value = "/delete")
	public ResponseEntity<SupplierDeleteResponse> f5(@RequestBody SupplierUpdateRequest request) {
		SupplierDeleteResponse response = new SupplierDeleteResponse();
		Supplier supplier = this.service.searchSupplier(request.getSupplier());
		if (supplier != null) {
			try {

				this.service.deleteSupplier(request.getSupplier());
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
	@GetMapping("/showAllByName/{name}")
	public ResponseEntity<SupplierShowAllByNameResponse> f6(@PathVariable(name="name") String name){
		SupplierShowAllByNameResponse response=new SupplierShowAllByNameResponse();
		
		List<Supplier> suppliersBySameName=this.service.getSuppliersByName(name);
		if(suppliersBySameName.isEmpty()) {
			response.setStatuscode(200);
			response.setDescription("There are no suppliers by same name "+name);
			response.setSuppliers(suppliersBySameName);
		}
		else
		{
			response.setStatuscode(200);
			response.setDescription("There are "+suppliersBySameName.size()+" with same name ");
			response.setSuppliers(suppliersBySameName);
		}
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/showAllByCity")
	public ResponseEntity<SupplierShowAllByCityResponse> f7(@RequestParam(name="txt_city") String city){
		SupplierShowAllByCityResponse response=new SupplierShowAllByCityResponse();
		List<Supplier> suppliersByCity=this.service.getSuppliersByCity(city);
		if(suppliersByCity.isEmpty()) {
			response.setStatuscode(200);
			response.setDescription("There are no suppliers by same name "+city);
			response.setSuppliers(suppliersByCity);
		}
		else
		{
			response.setStatuscode(200);
			response.setDescription("There are "+suppliersByCity.size()+" with same city ");
			response.setSuppliers(suppliersByCity);
		}
		return ResponseEntity.ok(response);
	}
}
