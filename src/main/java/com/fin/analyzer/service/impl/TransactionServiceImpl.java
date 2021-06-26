package com.fin.analyzer.service.impl;

import com.fin.analyzer.entity.AccountDetails;
import com.fin.analyzer.entity.TransactionDetails;
import com.fin.analyzer.exception.FinAnalyzerException;
import com.fin.analyzer.mapper.TransactionMapper;
import com.fin.analyzer.model.PayMentType;
import com.fin.analyzer.model.TransactionDetail;
import com.fin.analyzer.model.TransactionDetailsModel;
import com.fin.analyzer.repository.AccountRepository;
import com.fin.analyzer.repository.TransactionRepository;
import com.fin.analyzer.service.TransactionService;
import com.fin.analyzer.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TransactionMapper transactionMapper;
    @Autowired
    TransactionUtil transactionUtil;

    @Override
    public TransactionDetail createTransaction(TransactionDetail transactionDetail) {
        Optional<AccountDetails> accountDetails = this.accountRepository.findById(transactionDetail.getAccount_no());
        if(!accountDetails.isPresent()) {
            throw new FinAnalyzerException("Account No is not Present");
        }
        AccountDetails account = accountDetails.get();
        if(transactionDetail.getType().equalsIgnoreCase(String.valueOf(PayMentType.DEBIT)) && transactionDetail.getAmount()>account.getAmount()) {
            throw new FinAnalyzerException("Insufficient Balance");
        }
        if(transactionDetail.getAmount()<0) {
            throw new FinAnalyzerException("Amount is not valid");
        }
        TransactionDetails transactionDetails = this.transactionRepository.save(transactionMapper.ModelToEntityMapper(transactionDetail));
        return this.transactionMapper.EntityToModel(transactionDetails);

    }
    public List<TransactionDetailsModel> getTransactionDetails(Long accountId) {
        List<TransactionDetails> transactionDetails= transactionRepository.findByAccountNo(accountId);
        return transactionUtil.entityToModel(transactionDetails);
    }
}
