package com.fin.analyzer.controller;

import com.fin.analyzer.model.TransactionDetailsModel;
import com.fin.analyzer.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("accounts/transactions/{accountId}")
    public List<TransactionDetailsModel> getTransactionDetails(@PathVariable Long accountId) {
        return transactionService.getTransactionDetails(accountId);

    }
}
