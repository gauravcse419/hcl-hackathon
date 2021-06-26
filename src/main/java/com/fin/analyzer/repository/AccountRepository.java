package com.fin.analyzer.repository;

import com.fin.analyzer.entity.AccountDetails;
import com.fin.analyzer.entity.TransactionDetails;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountDetails, Long> {
}
