package com.ceepdode.reportingsystem.repository;

import com.ceepdode.reportingsystem.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("select vd from Transaction vd where vd.cardNumber=?1 and " +
            "( vd.transactionDate >= ?2 and vd.transactionDate <= ?3) order by vd.transactionDate")
    List<Transaction> findTransactionsByDate(Long cardNumber, Instant fromDate, Instant toDate);

    List<Transaction> findByCardNumber(Long cardNumber);

    List<Transaction> findByCardNumberAndTransaction(Long cardNumber, String transaction);

}
