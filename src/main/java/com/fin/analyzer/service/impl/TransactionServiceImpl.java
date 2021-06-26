package com.fin.analyzer.service.impl;

import com.fin.analyzer.entity.AccountDetails;
import com.fin.analyzer.entity.TransactionDetails;
import com.fin.analyzer.exception.FinAnalyzerException;
import com.fin.analyzer.mapper.TransactionMapper;
import com.fin.analyzer.model.TransactionDetail;
import com.fin.analyzer.repository.AccountRepository;
import com.fin.analyzer.repository.TransactionRepository;
import com.fin.analyzer.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TransactionMapper transactionMapper;

    @Override
    public TransactionDetail createTransaction(TransactionDetail transactionDetail) {
        Optional<AccountDetails> accountDetails = this.accountRepository.findById(transactionDetail.getAccount_no());
        if(!accountDetails.isPresent()) {
            throw new FinAnalyzerException("Account No is not Present");
        }
        AccountDetails account = accountDetails.get();
        if(transactionDetail.getType().equals("debit") && transactionDetail.getAmount()>account.getAmount()) {
            throw new FinAnalyzerException("Insufficient Balance");
        }
        TransactionDetails transactionDetails = this.transactionRepository.save(transactionMapper.ModelToEntityMapper(transactionDetail));
        return this.transactionMapper.EntityToModel(transactionDetails);

    }
}
