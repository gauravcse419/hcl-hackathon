package com.fin.analyzer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fin.analyzer.controller.TransactionController;
import com.fin.analyzer.model.TransactionDetail;
import com.fin.analyzer.service.TransactionService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@AutoConfigureMockMvc
public class TransactionControllerTest {

    @InjectMocks
    private TransactionController controller;

    @Mock
    TransactionService transactionService;

    @Mock
    private HttpServletRequest httpServletRequest;

    @Mock
    private HttpServletResponse httpServletResponse;

    private MockMvc mockMvc;

    TransactionDetail transactionDetailVo;

    @Before
    public void before() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        transactionDetailVo = new TransactionDetail();
        this.transactionDetailVo.setAccount_no(1);
        this.transactionDetailVo.setAmount(120);
        this.transactionDetailVo.setType("debit");
    }

    @Test
    public void testCreateProcessing() throws Exception {
        when(this.transactionService.createTransaction(transactionDetailVo)).thenReturn(transactionDetailVo);
         this.mockMvc.perform(MockMvcRequestBuilders.post("api/v2/transaction").content(asJsonString(transactionDetailVo))
               .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());

    }

    private static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception exc) {
            throw new RuntimeException(exc);
        }
    }

}
