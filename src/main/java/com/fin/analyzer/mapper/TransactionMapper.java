package com.fin.analyzer.mapper;

import com.fin.analyzer.entity.TransactionDetails;
import com.fin.analyzer.model.TransactionDetail;

public class TransactionMapper {
    public static TransactionDetails ModelToEntityMapper(TransactionDetail from) {
        TransactionDetails to = new TransactionDetails();
        if(to != null) {
            to.setAccountDetails(from.getAccount_no());
            to.setAmount(from.getAmount());
            to.setType(from.getType());
            


        } return to;
    }

}
