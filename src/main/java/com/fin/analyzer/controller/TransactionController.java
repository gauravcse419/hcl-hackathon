package com.fin.analyzer.controller;
import com.fin.analyzer.exception.FinAnalyzerException;
import com.fin.analyzer.model.TransactionAggregator;
import com.fin.analyzer.model.TransactionDetail;
import com.fin.analyzer.model.TransactionDetailsModel;
import com.fin.analyzer.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class TransactionController {

    Logger log = LoggerFactory.getLogger(TransactionController.class);

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

    @GetMapping(value = "/account/transactions/{accountNo}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TransactionAggregator>> getTransactionDetails(@PathVariable long accountNo, @RequestParam String fromDate, @RequestParam String toDate ) throws ParseException, ParseException {
        log.debug("Started Application TransactionController.getTransactionDetails()");
        if(fromDate.isEmpty() && toDate.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<TransactionAggregator> response = transactionService.getTransactionAggregator(accountNo,fromDate,toDate);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
