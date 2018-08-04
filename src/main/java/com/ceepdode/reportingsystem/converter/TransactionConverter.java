package com.ceepdode.reportingsystem.converter;

import com.ceepdode.reportingsystem.domain.Transaction;
import com.ceepdode.reportingsystem.dto.TransactionDto;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;

@Component
public class TransactionConverter {

    public Transaction convertToTransaction(TransactionDto transactionDto) {
        Transaction transaction = new Transaction();
        transaction.setId(transactionDto.getId());
        transaction.setTransactionDate(Instant.from(transactionDto.getTransactionDate()));
        transaction.setCardNumber(transactionDto.getCardNumber());
        transaction.setTransaction(transactionDto.getTransaction());

        return transaction;
    }

    public TransactionDto convertToTransactionDto(Transaction transaction){
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setId(transaction.getId());
        transactionDto.setTransactionDate(LocalDateTime.from(transaction.getTransactionDate()));
        transactionDto.setCardNumber(transaction.getCardNumber());
        transactionDto.setTransaction(transaction.getTransaction());

        return transactionDto;
    }

}
