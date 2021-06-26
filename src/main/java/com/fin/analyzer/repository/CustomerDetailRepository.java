package com.fin.analyzer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fin.analyzer.entity.CustomerDetails;

@Repository
public interface CustomerDetailRepository extends JpaRepository<CustomerDetails, Long> {

}
