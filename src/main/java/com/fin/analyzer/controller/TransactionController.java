package com.fin.analyzer.controller;
import com.fin.analyzer.exception.FinAnalyzerException;
import com.fin.analyzer.model.TransactionDetail;
import com.fin.analyzer.model.TransactionDetailsModel;
import com.fin.analyzer.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping(value = "/transaction")
    TransactionDetail createTransaction(@RequestBody TransactionDetail transactionDetail, HttpServletResponse httpServletResponse) throws IOException {
        try {
            TransactionDetail response = this.transactionService.createTransaction(transactionDetail);
            return response;
        } catch (Exception exc) {
            if(exc instanceof FinAnalyzerException) {
                httpServletResponse.sendError(HttpServletResponse.SC_PRECONDITION_FAILED, exc.getMessage());
            } else {
                httpServletResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, exc.getMessage());
            }

        }
        return null;
    }
    @GetMapping("accounts/transactions/{accountId}")
    public List<TransactionDetailsModel> getTransactionDetails(@PathVariable Long accountId) {
        return transactionService.getTransactionDetails(accountId);

    }

}
