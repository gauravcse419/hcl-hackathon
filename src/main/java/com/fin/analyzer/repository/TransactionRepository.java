package com.fin.analyzer.repository;

import com.fin.analyzer.entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface TransactionRepository  extends JpaRepository<TransactionDetails, Long> {

    List<TransactionDetails> findByAccountNo(Long accountNo);
}