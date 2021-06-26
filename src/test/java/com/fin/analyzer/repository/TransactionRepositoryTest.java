package com.fin.analyzer.repository;

import com.fin.analyzer.entity.AccountDetails;
import com.fin.analyzer.entity.TransactionDetails;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TransactionRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    TransactionRepository repository;

    @Test
    public void should_store_a_Transaction() {
        TransactionDetails transactionDetails = createTransaction();
        TransactionDetails transaction  = repository.save(transactionDetails);
        assertThat(transaction).isEqualTo(transactionDetails);
    }

    private TransactionDetails createTransaction() {
        TransactionDetails transactionDetails=new TransactionDetails();
        transactionDetails.setAmount(10000.0);
        transactionDetails.setBalanceAmount(10000.0);
        AccountDetails accountDetails =new AccountDetails();
        accountDetails.setAccountNo(1234l);
        String input = "2007-11-11 12:13:14" ;
        java.sql.Timestamp ts = java.sql.Timestamp.valueOf( input ) ;
        transactionDetails.setTransactionDate(ts);
        transactionDetails.setTransactionDescription("tranfer to accounting");
        transactionDetails.setType("credit");
        //transactionDetails.setAccountDetails(accountDetails);
        return transactionDetails;
    }

    @Test
    public void should_delete_all_Transaction() {
        entityManager.persist(createTransaction());
        entityManager.persist(createTransaction());

        repository.deleteAll();

        assertThat(repository.findAll()).isEmpty();
    }

    @Test
    public void should_find_all_Transaction() {

        entityManager.persist(createTransaction());

        entityManager.persist(createTransaction());

        entityManager.persist(createTransaction());

        Iterable<TransactionDetails> transactionDetails = repository.findAll();

        assertThat(transactionDetails).isNotEmpty();
    }

    @Test
    public void should_find_Transaction_by_id() {
        TransactionDetails transactionDetails=createTransaction();
        TransactionDetails transactionDetailResponse=entityManager.persist(transactionDetails);

        List<TransactionDetails> foundTransaction = repository.findByAccountNo(transactionDetailResponse.getAccountNo());

        assertThat(foundTransaction).isNotEmpty();

    }




}