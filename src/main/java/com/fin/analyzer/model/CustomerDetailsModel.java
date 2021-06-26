package com.fin.analyzer.model;

import com.fin.analyzer.entity.AccountDetails;

import java.sql.Timestamp;
import java.util.List;


public class CustomerDetailsModel {
	int customerId;
	String name;
	String emailId;
	String phone;

	public List<AccountDetailsModel> getAccountDetails() {
		return accountDetails;
	}

	public void setAccountDetails(List<AccountDetailsModel> accountDetails) {
		this.accountDetails = accountDetails;
	}

	Timestamp Date;

	List<AccountDetailsModel> accountDetails;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Timestamp getDate() {
		return Date;
	}

	public void setDate(Timestamp date) {
		Date = date;
	}

}
