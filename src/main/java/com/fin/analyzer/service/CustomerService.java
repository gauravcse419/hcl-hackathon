package com.fin.analyzer.service;

import org.springframework.stereotype.Component;

import com.fin.analyzer.model.CustomerDetailsModel;

public interface CustomerService {

	CustomerDetailsModel createCustomer(CustomerDetailsModel customerDetails);

}
