package com.fin.analyzer.controller;

import com.fin.analyzer.model.TransactionDetail;
import com.fin.analyzer.service.TransactionService;
import com.fin.analyzer.service.impl.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/transaction")
    TransactionDetail newEmployee(@RequestBody TransactionDetail transactionDetail) {
        this.transactionService.createTransaction(transactionDetail);
      return null;
    }
}
