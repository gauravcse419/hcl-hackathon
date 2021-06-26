package com.fin.analyzer.model;

import com.fin.analyzer.entity.AccountDetails;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class TransactionDetail {
    int transaction_id;
    Long account_no;
    AccountDetails accountDetails;
    Timestamp transactionDate;
    private String type;
    private double amount;
    private double balance_amount;


}
