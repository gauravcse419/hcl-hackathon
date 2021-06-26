package com.fin.analyzer.controller;

import com.fin.analyzer.model.TransactionDetail;
import com.fin.analyzer.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping(value = "/transaction")
    TransactionDetail createTransaction(@RequestBody TransactionDetail transactionDetail) {
       this.transactionService.createTransaction(transactionDetail);
      return null;
    }

}
