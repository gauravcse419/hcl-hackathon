package com.fin.analyzer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fin.analyzer.model.TransactionDetailsModel;
import com.fin.analyzer.service.TransactionService;
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
public class TransactionControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    TransactionService transactionService;


    @Test
    public void getTransactionByAccountId() throws Exception {
        when(transactionService.getTransactionDetails(Mockito.anyLong())).thenReturn(createTransactionModel());
        mvc.perform(MockMvcRequestBuilders.get("/api/v1/accounts/transactions/"+123l+"").accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].amount").value(1000.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].transactionDescription").value("transactionDescription"));;
    }

    private List<TransactionDetailsModel> createTransactionModel() {
        List<TransactionDetailsModel> transactionDetailsModels = new ArrayList<>();
        transactionDetailsModels.add(TransactionDetailsModel.builder().amount(1000.0).transactionDescription("transactionDescription").build());
        return transactionDetailsModels;

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}