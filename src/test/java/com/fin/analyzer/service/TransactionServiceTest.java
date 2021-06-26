package com.fin.analyzer.service;

import com.fin.analyzer.entity.AccountDetails;
import com.fin.analyzer.entity.TransactionDetails;
import com.fin.analyzer.model.TransactionDetailsModel;
import com.fin.analyzer.repository.TransactionRepository;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.when;

import com.fin.analyzer.util.TransactionUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceTest {

	@Mock
	TransactionRepository repository;

	@Mock
	TransactionUtil transactionUtil;

	@InjectMocks
	TransactionService transactionService;


	@Test
	public void getTransactionById() {
		Long accountNo=123l;
		List<TransactionDetails> transactionDetailsList=new ArrayList<>();
		transactionDetailsList.add(createTransaction());
		when(repository.findByAccountNo(accountNo)).thenReturn(transactionDetailsList);
		when(transactionUtil.entityToModel(transactionDetailsList)).thenReturn(createTransactionModel());
		List<TransactionDetailsModel> transactionDetails=transactionService.getTransactionDetails(accountNo);
		assertThat(transactionDetails).isNotEmpty();

	}


	private TransactionDetails createTransaction() {
		TransactionDetails transactionDetails=new TransactionDetails();
		transactionDetails.setAmount(10000.0);
		transactionDetails.setBalanceAmount(10000.0);
		AccountDetails accountDetails =new AccountDetails();
		accountDetails.setAccountNo(123l);
		String input = "2007-11-11 12:13:14" ;
		java.sql.Timestamp ts = java.sql.Timestamp.valueOf( input ) ;
		transactionDetails.setTransactionDate(ts);
		transactionDetails.setTransactionDescription("tranfer to accounting");
		transactionDetails.setType("CREDIT");
		//transactionDetails.setAccountDetails(accountDetails);
		return transactionDetails;
	}

	private List<TransactionDetailsModel> createTransactionModel() {
		List<TransactionDetailsModel> transactionDetailsModels=new ArrayList<>();
		transactionDetailsModels.add(TransactionDetailsModel.builder().amount(1000.0).transactionDescription("transactionDescription").build());
		return transactionDetailsModels;

	}
	

}
