package com.fin.analyzer.model;

import java.util.Set;

public class AccountDetailsModel {

    private long account_no;

    private long customer_id;

    private String account_type;

    private double amount;

    private CustomerDetailsModel customerDetailsModel;

    private Set<TransactionDetail> transactionDetail;

    public long getAccount_no() {
        return account_no;
    }

    public void setAccount_no(long account_no) {
        this.account_no = account_no;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public CustomerDetailsModel getCustomerDetailsModel() {
        return customerDetailsModel;
    }

    public void setCustomerDetailsModel(CustomerDetailsModel customerDetailsModel) {
        this.customerDetailsModel = customerDetailsModel;
    }

    public Set<TransactionDetail> getTransactionDetail() {
        return transactionDetail;
    }

    public void setTransactionDetail(Set<TransactionDetail> transactionDetail) {
        this.transactionDetail = transactionDetail;
    }
}
