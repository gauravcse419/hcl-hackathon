package com.fin.analyzer.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "account_details")
@Data
public class AccountDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int account_no;
    @Column
    private String account_type;
    @Column
    private double amount;

//    @Column
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "customer_id", nullable = false)
//    private CustomerDetails customerDetails;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="account_no")
    private Set<TransactionDetails> transactionDetailsList;


}
