package com.ceepdode.reportingsystem.repository;

import com.ceepdode.reportingsystem.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
