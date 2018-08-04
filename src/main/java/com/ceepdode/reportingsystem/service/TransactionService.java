package com.ceepdode.reportingsystem.service;

import com.ceepdode.reportingsystem.domain.Transaction;
import com.ceepdode.reportingsystem.dto.TransactionDto;

import java.time.Instant;
import java.util.List;

public interface TransactionService {

    void createTransaction(Transaction transaction);

    List<TransactionDto> findTransactionsByDate(Long cardNumber, Instant fromDate, Instant toDate);

    List<TransactionDto> findTransactionsByCardNumber(Long cardNumber);

    List<TransactionDto> findTransactionsByActionCredits(Long cardNumber, String actionCredits);

}
