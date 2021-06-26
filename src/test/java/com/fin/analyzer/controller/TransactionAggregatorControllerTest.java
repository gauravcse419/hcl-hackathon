package com.fin.analyzer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fin.analyzer.model.TransactionAggregator;
import com.fin.analyzer.service.TransactionService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TransactionController.class)
public class TransactionAggregatorControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    TransactionService transactionService;

    @Before
    public void before() {

    }

    @Test
    public void getTransactionByAccountId() throws Exception {
        List<TransactionAggregator> transaction = new ArrayList<>();
        TransactionAggregator transactionAggregator = new TransactionAggregator();
        transactionAggregator.setTransactionId(1);
        transaction.add(transactionAggregator);

        when(transactionService.getTransactionAggregator(Mockito.anyLong(), Mockito.anyString(), Mockito.anyString())).thenReturn(transaction);
        mvc.perform(MockMvcRequestBuilders.get("/api/v1/account/transactions/12?fromDate=12-12-2020T09:09:09&toDate=12-12-2020T09:09:09").accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].transactionId").value(1));

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
