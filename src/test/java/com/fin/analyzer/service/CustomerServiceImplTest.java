package com.fin.analyzer.service;

import com.fin.analyzer.repository.CustomerDetailRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fin.analyzer.entity.CustomerDetails;
import com.fin.analyzer.exception.CustomerCreateException;
import com.fin.analyzer.model.CustomerDetailsModel;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceImplTest {


	@Mock
	CustomerDetailRepository customerDetailRepository;

	CustomerDetails customerDetails = null;
	CustomerDetailsModel customerDetailsModel = null;

	@Before
	public void init() throws Exception {
		MockitoAnnotations.initMocks(this);
		customerDetailsModel = CustomerUtilMapperTest.getCustomerDetails();
		customerDetails = CustomerUtilMapperTest.getCustomerDetailsEntity();
	}

	@Test
	public void createCustomer() {
		Mockito.when(customerDetailRepository.save(customerDetails)).thenReturn(customerDetails);
		Assert.assertEquals("name", customerDetails.getCustomerName());
	}

	@Test
	public void createCustomerFail() {
		Mockito.when(customerDetailRepository.save(customerDetails)).thenThrow(new CustomerCreateException(500, null));
		Assert.assertNotEquals("name1", customerDetails.getCustomerName());
	}

}
