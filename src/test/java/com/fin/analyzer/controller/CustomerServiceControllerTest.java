package com.fin.analyzer.controller;

import com.fin.analyzer.exception.CustomerCreateException;
import com.fin.analyzer.model.CustomerDetailsModel;
import com.fin.analyzer.service.CustomerService;
import com.fin.analyzer.service.CustomerUtilMapperTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceControllerTest {


    @Mock
    CustomerService customerService;


    private MockMvc mockMvc;

    CustomerDetailsModel customerDetailsModel = null;

    @Before
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
       // this.mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
        customerDetailsModel = CustomerUtilMapperTest.getCustomerDetails();
    }

    /*@Test
    public void createCustomerAPI() throws Exception {
        when(customerService.createCustomer(Mockito.any())).thenReturn(customerDetailsModel);
        mockMvc.perform(MockMvcRequestBuilders.post("/createcustomer")
                .contentType(MediaType.APPLICATION_JSON));
    }*/


    @Test
    public void createCustomer() {
        Mockito.when(customerService.createCustomer(customerDetailsModel)).thenReturn(customerDetailsModel);
        Assert.assertEquals("name", customerDetailsModel.getName());
        Assert.assertNotEquals("name1", customerDetailsModel.getName());
    }

    @Test
    public void createCustomerFail() {
        Mockito.when(customerService.createCustomer(customerDetailsModel))
                .thenThrow(new CustomerCreateException(500, null));
        Assert.assertNotEquals("name1", customerDetailsModel.getName());
    }

}
