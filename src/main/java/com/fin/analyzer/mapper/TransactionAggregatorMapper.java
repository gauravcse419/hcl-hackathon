package com.fin.analyzer.mapper;

import com.fin.analyzer.entity.TransactionDetails;
import com.fin.analyzer.model.TransactionAggregator;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionAggregatorMapper {
    public void createAggregatorReponse(List<TransactionAggregator> transactionAggregatorList, List<TransactionDetails> entityRes) {
        entityRes.stream().forEach(detail -> {
            TransactionAggregator transactionAggregator = new TransactionAggregator();
            transactionAggregator.setTransactionId(detail.getTransactionId());
            transactionAggregator.setDate(detail.getTransactionDate());
            transactionAggregator.setPayMentType(detail.getType());
            transactionAggregator.setClosinBalance(detail.getBalanceAmount());
            transactionAggregator.setAmount(detail.getAmount());
            transactionAggregatorList.add(transactionAggregator);
        });


    }
}