package com.fin.analyzer.util;


import com.fin.analyzer.entity.TransactionDetails;
import com.fin.analyzer.exception.TransactionsNotFoundException;
import com.fin.analyzer.model.PayMentType;
import com.fin.analyzer.model.TransactionDetailsModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransactionUtil {
    public List<TransactionDetailsModel> entityToModel(List<TransactionDetails> transactionDetails) {

        if(transactionDetails.isEmpty()){
            throw new TransactionsNotFoundException(HttpStatus.NOT_FOUND.value(),"Transaction Details are not found");
        }
        List<TransactionDetailsModel> transactions=new ArrayList<>();
        return transactionDetails.stream().map(this::getTransactions).collect(Collectors.toList());

    }

    private TransactionDetailsModel getTransactions(TransactionDetails transactionDetail) {
        //int customer_id= transactionDetail.getAccountDetails().getCustomerDetails().getCustomer_id();
        return TransactionDetailsModel.builder()
                .amount(transactionDetail.getAmount())
                .payMentType(PayMentType.valueOf(transactionDetail.getType()))
                .date(transactionDetail.getTransactionDate())
                .transactionDescription(transactionDetail.getType()).build();

    }
}