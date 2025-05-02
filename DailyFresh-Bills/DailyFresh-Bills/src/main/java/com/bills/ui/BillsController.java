package com.bills.ui;

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

import com.bills.dto.request.BillsAddRequest;
import com.bills.dto.request.BillsUpdateRequest;
import com.bills.dto.response.BillsAddResponse;
import com.bills.dto.response.BillsDeleteResponse;
import com.bills.dto.response.BillsModifyResponse;
import com.bills.dto.response.BillsSearchResponse;
import com.bills.dto.response.BillsShowAllResponse;
import com.bills.exception.BillsNotFoundException;
import com.bills.model.Bill;
import com.bills.service.BillsService;

@RestController
@RequestMapping(value = "/apiBill")
public class BillsController {
	@Autowired
	BillsService service;

	@PostMapping(value = "/add")
	public ResponseEntity<BillsAddResponse> f1(@RequestBody BillsAddRequest request) {

		Bill bill1 = this.service.addNewBill(request.getBills());
		BillsAddResponse response = new BillsAddResponse();
		response.setStatusCode(200);
		response.setDescription("Bills added successfully");
		response.setBills(bill1);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PutMapping(value = "/modify")
	public ResponseEntity<BillsModifyResponse> f2(@RequestBody BillsUpdateRequest request) {
		BillsModifyResponse response = new BillsModifyResponse();
		Bill stores1 = this.service.searchBill(request.getBills());
		if (stores1 != null) {
			Bill stores2 = this.service.updateBill(request.getBills());
			response.setStatusCode(200);
			response.setDescription("Bills modify successfully");
			response.setBills(stores2);
			return ResponseEntity.ok(response);
		} else {
			response.setStatusCode(404);
			response.setDescription("Bills not modify successfully");
			response.setBills(null);
			return new ResponseEntity<BillsModifyResponse>(response, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/find/{sid}")
	public ResponseEntity<BillsSearchResponse> f3(@PathVariable(name = "sid") int sid) throws Exception {
		BillsSearchResponse response = new BillsSearchResponse();
		Bill stores = this.service.searchBill(sid);
		if (stores != null) {
			response.setStatusCode(200);
			response.setDescription("Bills fetched successfully");
			response.setBills(stores);
			return new ResponseEntity<BillsSearchResponse>(response, HttpStatus.OK);
		} else {
			Exception exception = new BillsNotFoundException("Bills not found");
			throw exception;
		}
	}

	@GetMapping(value = "/showAll")
	public ResponseEntity<BillsShowAllResponse> f4() {
		List<Bill> stores = this.service.getAllBills();
		BillsShowAllResponse response = new BillsShowAllResponse();
		response.setStatuscode(200);
		response.setDescription("All Bills fetched");
		response.setBills(stores);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping(value = "/delete")
	public ResponseEntity<BillsDeleteResponse> f5(@RequestBody BillsUpdateRequest request) {
		BillsDeleteResponse response = new BillsDeleteResponse();
		Bill stores = this.service.searchBill(request.getBills());
		if (stores != null) {
			try {

				this.service.deleteBill(request.getBills());
				response.setStatusCode(200);
				response.setDescription("Bills Deleted Successfully");
				response.setDeleteStatus(true);
				return ResponseEntity.ok().body(response);

			} catch (Exception e) {
				response.setStatusCode(500);
				response.setDescription("Bills not Deleted");
				response.setDeleteStatus(false);
				return ResponseEntity.ok().body(response);
			}
		} else {
			response.setStatusCode(404);
			response.setDescription("Bills not Deleted");
			response.setDeleteStatus(false);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}
	
}
