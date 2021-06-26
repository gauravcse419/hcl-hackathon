package com.fin.analyzer.service.impl;

import com.fin.analyzer.mapper.TransactionMapper;
import com.fin.analyzer.model.TransactionDetail;
import com.fin.analyzer.repository.TransactionRepository;
import com.fin.analyzer.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public TransactionDetail createTransaction(TransactionDetail transactionDetail) {
    this.transactionRepository.save(TransactionMapper.ModelToEntityMapper(transactionDetail));

        return null;
    }
}
