package com.fin.analyzer.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class TransactionAggregator {

    private int transactionId;
    private double amount;
    private String payMentType;
    private double closinBalance;
    private Timestamp date;


}
