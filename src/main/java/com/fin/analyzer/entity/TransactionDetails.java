package com.fin.analyzer.entity;

import lombok.Data;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name = "customer_details")
@Data
public class TransactionDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transaction_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_no", nullable = false)
    private AccountDetails accountDetails;

    @Column
    private Timestamp transactionDate;
    @Column
    private String type;
    @Column
    private double amount;
    @Column
    private double balance_amount;

}
