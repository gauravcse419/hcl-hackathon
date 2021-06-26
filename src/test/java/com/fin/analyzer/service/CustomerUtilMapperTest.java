package com.fin.analyzer.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fin.analyzer.entity.CustomerDetails;
import com.fin.analyzer.model.AccountDetailsModel;
import com.fin.analyzer.model.CustomerDetailsModel;
import com.fin.analyzer.model.TransactionDetail;
import org.assertj.core.util.Arrays;

public class CustomerUtilMapperTest {

	public static CustomerDetailsModel getCustomerDetails() {
		CustomerDetailsModel customer = new CustomerDetailsModel();
		customer.setCustomerId(1);
		customer.setDate(new Timestamp(1));
		customer.setEmailId("emailId");
		customer.setName("name");
		customer.setPhone("123");
		customer.setAccountDetails(mapAccountDetailsModel());
		return customer;
	}

	private static List<AccountDetailsModel> mapAccountDetailsModel() {
		List<AccountDetailsModel> accountDetailsModels = new ArrayList<AccountDetailsModel>();
		AccountDetailsModel accountDetailsModel = new AccountDetailsModel();
		accountDetailsModel.setAccount_no(1);
		accountDetailsModel.setAccount_type("account_type");
		accountDetailsModel.setAmount(1.0);
		accountDetailsModel.setCustomer_id(1);
		accountDetailsModel.setTransactionDetail(transactionDetailMap());
		accountDetailsModels.add(accountDetailsModel);
		return accountDetailsModels;
	}

	private static Set<TransactionDetail> transactionDetailMap() {
		Set<TransactionDetail> transactionDetails = new HashSet<>();
		TransactionDetail transactionDetail = new TransactionDetail();
		transactionDetail.setAmount(1.0);
		transactionDetail.setBalance_amount(1.0);
		transactionDetail.setTransaction_id(1);
		transactionDetail.setTransactionDate(new Timestamp(1L));

		transactionDetails.add(transactionDetail);
		return transactionDetails;
	}



	public static CustomerDetails getCustomerDetailsEntity() {
		CustomerDetails customer = new CustomerDetails();
		customer.setCustomerId(1);
		customer.setDate(new Timestamp(1));
		customer.setEmailId("emailId");
		customer.setCustomerName("name");
		customer.setPhoneNo("123");
		return customer;
	}

}
