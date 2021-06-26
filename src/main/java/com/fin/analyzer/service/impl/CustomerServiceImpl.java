package com.fin.analyzer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fin.analyzer.entity.CustomerDetails;
import com.fin.analyzer.model.CustomerDetailsModel;
import com.fin.analyzer.repository.CustomerDetailRepository;
import com.fin.analyzer.service.CustomerService;
import com.fin.analyzer.util.CustomerUtil;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDetailRepository customerDetailRepository;

	@Override
	public CustomerDetailsModel createCustomer(CustomerDetailsModel customerDetailsResponse) {
		CustomerDetailsModel customerDetailResponse = new CustomerDetailsModel();
		CustomerUtil customerUtil = new CustomerUtil();
		try {
			CustomerDetails customerDetails = customerUtil.addCustomer(customerDetailResponse);
			customerDetailRepository.save(customerDetails);
		} catch (DataIntegrityViolationException e) {
			
		}
		return customerDetailResponse;
	}

}
