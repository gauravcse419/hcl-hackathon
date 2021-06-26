package com.fin.analyzer.util;

import com.fin.analyzer.entity.CustomerDetails;
import com.fin.analyzer.model.CustomerDetailsModel;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fin.analyzer.entity.AccountDetails;
import com.fin.analyzer.entity.CustomerDetails;
import com.fin.analyzer.model.AccountDetailsModel;
import com.fin.analyzer.model.CustomerDetailsModel;
public class CustomerUtil {


    public CustomerDetails addCustomer(CustomerDetailsModel customerDetailModel) {
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setCustomerName(customerDetailModel.getName());
        customerDetails.setEmailId(customerDetailModel.getEmailId());
        customerDetails.setPhoneNo(customerDetailModel.getPhone());
        customerDetails.setDate(new Timestamp(new Date().getTime()));
        customerDetails.setAccountDetails(mapAccountDetails(customerDetailModel.getAccountDetails()));
        return customerDetails;
    }

    private List<AccountDetails> mapAccountDetails(List<AccountDetailsModel> accountDetailsModels) {
        List<AccountDetails> accountDetails = new ArrayList<>();
        accountDetailsModels.forEach(accountDetailsModel -> accountDetails.add(mapAccountDetail(accountDetailsModel)));
        return accountDetails;
    }

    private AccountDetails mapAccountDetail(AccountDetailsModel accountDetailsModel) {
        AccountDetails accountDetails = new AccountDetails();
        accountDetails.setAccountNo(accountDetailsModel.getAccount_no());
        accountDetails.setAccountType(accountDetailsModel.getAccount_type());
        accountDetails.setCustomerId(accountDetailsModel.getCustomer_id());
        return accountDetails;
    }
}
