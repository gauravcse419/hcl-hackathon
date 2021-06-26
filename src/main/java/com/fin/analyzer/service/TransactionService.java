package com.fin.analyzer.service;

import com.fin.analyzer.model.TransactionDetail;
import com.fin.analyzer.model.TransactionDetailsModel;

import java.util.List;

public interface TransactionService {

    TransactionDetail createTransaction(TransactionDetail transactionDetail);

    List<TransactionDetailsModel> getTransactionDetails(Long accountId);

}
