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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.fin.analyzer.controller.TransactionAggregatorControllerTest.asJsonString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerServiceControllerTest {


    @MockBean
    CustomerService customerService;

    @Autowired
    private MockMvc mockMvc;


    @Before
    public void before(){

    }

    @Test
    public void createCustomerAPI() throws Exception {
        CustomerDetailsModel customerDetailsModel = new CustomerDetailsModel();
        customerDetailsModel.setCustomerId(1);
        when(customerService.createCustomer(Mockito.any())).thenReturn(customerDetailsModel);
        mockMvc.perform(MockMvcRequestBuilders.post("/createcustomer")
                .content(asJsonString(customerDetailsModel)).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());

    }
    @Test
    public void createCustomerAPIException() throws Exception {
        CustomerDetailsModel customerDetailsModel = new CustomerDetailsModel();
        customerDetailsModel.setCustomerId(1);
        when(customerService.createCustomer(Mockito.any())).thenThrow(new CustomerCreateException(Mockito.anyInt(),Mockito.anyString()));


    }


   /* @Test
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
    }*/

}
