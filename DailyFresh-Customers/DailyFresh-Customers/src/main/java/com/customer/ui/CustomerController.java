package com.customer.ui;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.customer.model.Customer;
import com.customer.order.dto.OrderDTO;
import com.customer.service.CustomerService;
import com.customer.dto.customer.request.CustomerDeleteRequest;
import com.customer.dto.customer.request.CustomerUpdateRequest;
import com.customer.dto.customer.request.OrderPlaceRequest;
import com.customer.dto.customer.response.CustomerAddResponse;
import com.customer.dto.customer.response.CustomerDeleteResponse;
import com.customer.dto.customer.response.CustomerModifyResponse;
import com.customer.dto.customer.response.CustomerSearchResponse;
import com.customer.dto.customer.response.CustomerShowAllByCity;
import com.customer.dto.customer.response.CustomerShowAllByLocation;
import com.customer.dto.customer.response.CustomerShowAllByNameResponse;
import com.customer.dto.customer.response.CustomerShowAllByPhoneNoResponse;
import com.customer.dto.customer.response.CustomerShowAllResponse;
import com.customer.exception.CustomerNotFoundException;

@RestController
@RequestMapping(value="/customer")
public class CustomerController {

	@Autowired
	CustomerService service;
	
	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping(value = "/add")
	public ResponseEntity<CustomerAddResponse> f1(@RequestBody CustomerAddResponse request) {
		Customer customer1 = this.service.addNewCustomer(request.getCustomer());
		CustomerAddResponse response = new CustomerAddResponse();
		response.setStatusCode(201);
		response.setDescription("Customer Added succesfully");
		response.setCustomer(customer1);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PutMapping(value = "/modify")
	public ResponseEntity<CustomerModifyResponse> f2(@RequestBody CustomerUpdateRequest request) throws Exception {
		Customer customer1 = this.service.searchCustomer(request.getCustomer());
		CustomerModifyResponse response = new CustomerModifyResponse();
		if (customer1 != null) {
			Customer customer2 = this.service.updateCustomer(request.getCustomer());
			response.setStatusCode(200);
			response.setDescription("Customer updated succesfully");
			response.setCustomer(customer2);
			return ResponseEntity.ok(response);
		} else {
			Exception exception = new CustomerNotFoundException("Customer Not Found");
			throw exception;
		}
	}

	@GetMapping(value = "/find/{cid}")
	public ResponseEntity<CustomerSearchResponse> f3(@PathVariable(name = "cid") int cid) throws Exception {
		Customer customer1 = this.service.searchCustomer(cid);
		CustomerSearchResponse response = new CustomerSearchResponse();
		if (customer1 != null) {
			response.setStatusCode(200);
			response.setDiscription("Customer search Successfully");
			response.setSearchStatus(true);
			return ResponseEntity.ok(response);
		} else {

			Exception exception = new CustomerNotFoundException("Customer Not Found");
			throw exception;
		}
	}

	@GetMapping(value = "/showAll", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<CustomerShowAllResponse> f4() {
		List<Customer> customers = this.service.getAllCustomers();
		CustomerShowAllResponse response = new CustomerShowAllResponse();
		response.setStatusCode(200);
		response.setDescription("All Customer Fetched");
		response.setCustomers(customers);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping(value = "/delete")
	public ResponseEntity<CustomerDeleteResponse> f5(@RequestBody CustomerDeleteRequest request) throws Exception {
		CustomerDeleteResponse response = new CustomerDeleteResponse();
		Customer customer1 = this.service.searchCustomer(request.getCustomer());
		if (customer1 != null) {
			try {
				this.service.deleteCustomer(request.getCustomer());
				response.setStatusCode(200);
				response.setDiscription("Customer Deleted Successfully");
				response.setDeleteStatus(true);
				return ResponseEntity.ok().body(response);

			} catch (Exception e) {
				response.setStatusCode(500);
				response.setDiscription("Customer Not Deleted");
				response.setDeleteStatus(false);
				return ResponseEntity.internalServerError().body(response);
			}
		} else {
			Exception exception = new CustomerNotFoundException("Customer Not Found");
			throw exception;
		}
	}

	@GetMapping("/showAllByName/{name}")
	public ResponseEntity<CustomerShowAllByNameResponse> f6(@PathVariable(name = "name") String name) {
		CustomerShowAllByNameResponse response = new CustomerShowAllByNameResponse();
		List<Customer> customerBySameName = this.service.getAllCustomerByName(name);

		if (customerBySameName.isEmpty()) {
			response.setStatusCode(200);
			response.setDescription("There is no Customer by same name " + name);
			response.setCustomers(customerBySameName);
		} else {
			response.setStatusCode(200);
			response.setDescription("There are " + customerBySameName.size() + "With Same name");
			response.setCustomers(customerBySameName);
		}
		return ResponseEntity.ok(response);
	}

	@GetMapping("/showAllByPhNumber")
	public ResponseEntity<CustomerShowAllByPhoneNoResponse> f7(@RequestParam(name = "txt_num") String num) {
		CustomerShowAllByPhoneNoResponse response = new CustomerShowAllByPhoneNoResponse();
		List<Customer> customerSamePhoneNumber = this.service.getAllCustomersByPhoneNumber(num);

		if (customerSamePhoneNumber.isEmpty()) {
			response.setStatusCode(200);
			response.setDescription("There is no Customer by same PhoneNumber " + num);
			response.setCustomer(customerSamePhoneNumber);
		} else {
			response.setStatusCode(200);
			response.setDescription("There are " + customerSamePhoneNumber.size() + "With Same PhoneNumber");
			response.setCustomer(customerSamePhoneNumber);
			}
		return ResponseEntity.ok(response);
	}
	@GetMapping("/showAllByLocation")
	public ResponseEntity<List<Customer>> f8(@RequestParam(name = "txt_location") String location) {
		CustomerShowAllByLocation response=new CustomerShowAllByLocation();
		List<Customer> customersByLocation = this.service.getCustomerAddress_Location(location);
		if (customersByLocation.isEmpty()) {
			response.setStatusCode(200);
			response.setDescription("There is no Customer by same Location ");
			response.setCustomers(customersByLocation);
		} else {
			response.setStatusCode(200);
			response.setDescription("There are " + customersByLocation.size() + "With Same Location");
			response.setCustomers(customersByLocation);
			}
		return ResponseEntity.ok(customersByLocation);
	}
	@GetMapping("/showAllByCity")
	public ResponseEntity<List<Customer>> f9(@RequestParam(name = "txt_city") String City) {
		CustomerShowAllByCity response=new CustomerShowAllByCity();
		List<Customer> customersByCity = this.service.getCustomerAddress_Location(City);
		if (customersByCity.isEmpty()) {
			response.setStatusCode(200);
			response.setDescription("There is no Customer by same Location ");
			response.setCustomers(customersByCity);
		} else {
			response.setStatusCode(200);
			response.setDescription("There are " + customersByCity.size() + "With Same City");
			response.setCustomers(customersByCity);
			}
		return ResponseEntity.ok(customersByCity);
	}
	
	@PostMapping("/placeOrder")
	public ResponseEntity<OrderDTO> f10(@RequestBody OrderPlaceRequest orderPlaceRequest){
		OrderDTO orderDTO = 
		orderPlaceRequest.getOrderDTO();
		String url = "http://localhost:8206/order/generateBill";
		OrderDTO order = restTemplate.postForObject(url, orderDTO,null);
		return ResponseEntity.ok(orderDTO);
	}
	

}
