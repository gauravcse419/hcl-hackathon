package com.fin.analyzer.service;

import com.fin.analyzer.entity.TransactionDetails;
import com.fin.analyzer.model.TransactionDetail;
import com.fin.analyzer.model.TransactionDetailsModel;
import com.fin.analyzer.repository.TransactionRepository;
import com.fin.analyzer.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    TransactionUtil transactionUtil;
    public List<TransactionDetailsModel> getTransactionDetails(Long accountId) {
        List<TransactionDetails> transactionDetails= transactionRepository.findByAccountNo(accountId);
        return transactionUtil.entityToModel(transactionDetails);
    }
}
