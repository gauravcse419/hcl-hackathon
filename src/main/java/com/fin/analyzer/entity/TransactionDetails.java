package com.fin.analyzer.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "transaction_detail")
@Data
public class TransactionDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transaction_id;

    @ManyToOne(fetch = FetchType.LAZY)
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
