package com.fin.analyzer.mapper;

import com.fin.analyzer.entity.AccountDetails;
import com.fin.analyzer.entity.TransactionDetails;
import com.fin.analyzer.model.TransactionDetail;
import com.fin.analyzer.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@Component
public class TransactionMapper {

    @Autowired
    AccountRepository accountRepository;

    public TransactionDetails ModelToEntityMapper(TransactionDetail from) {
        TransactionDetails to = new TransactionDetails();
        if(from != null) {
            to.setAccountNo(from.getAccount_no());
            to.setAmount(from.getAmount());
            to.setType(from.getType());
            to.setTransactionDate(new Timestamp(new Date().getTime()));
        } return to;
    }

    public TransactionDetail EntityToModel(TransactionDetails from) {
        TransactionDetail to = new TransactionDetail();
        if(from != null) {
            to.setTransaction_id(from.getTransactionId());
            to.setAmount(from.getAmount());
            to.setType(from.getType());
            to.setAccount_no(from.getAccountNo());
        }
        return to;

    }

}
