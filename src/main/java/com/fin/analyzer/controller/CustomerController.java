package com.fin.analyzer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fin.analyzer.exception.CustomerCreateException;
import com.fin.analyzer.model.CustomerDetailsModel;
import com.fin.analyzer.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping(value="/createcustomer", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerDetailsModel> createCustomer(@RequestBody CustomerDetailsModel customerDetails) {
		CustomerDetailsModel customerDetail = new CustomerDetailsModel();
		try {
			customerDetail = customerService.createCustomer(customerDetails);
		}catch (CustomerCreateException cuException) {
			throw new CustomerCreateException(cuException.getErrorCode(), cuException.getMessage());
		}
		return new ResponseEntity<>(customerDetail, HttpStatus.OK);
	}
}
