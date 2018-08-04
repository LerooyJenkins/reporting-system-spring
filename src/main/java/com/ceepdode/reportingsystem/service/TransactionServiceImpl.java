package com.ceepdode.reportingsystem.service;

import com.ceepdode.reportingsystem.converter.TransactionConverter;
import com.ceepdode.reportingsystem.domain.Transaction;
import com.ceepdode.reportingsystem.dto.TransactionDto;
import com.ceepdode.reportingsystem.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionConverter transactionConverter;

    @Override
    public void createTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    public List<TransactionDto> findTransactionsByDate(Long cardNumber, Instant fromDate, Instant toDate) {
        List<TransactionDto> transactionDtos = new ArrayList<>();
        List<Transaction> transactionsByDate = transactionRepository.findTransactionsByDate(cardNumber, fromDate, toDate);

        for (int i = 0; i < transactionsByDate.size(); i++) {
            transactionDtos.add(transactionConverter.convertToTransactionDto(transactionsByDate.get(i)));
        }
        return transactionDtos;
    }

    @Override
    public List<TransactionDto> findTransactionsByCardNumber(Long cardNumber) {
        List<TransactionDto> transactionDtos = new ArrayList<>();
        List<Transaction> transactionsByCardNumber = transactionRepository.findByCardNumber(cardNumber);

        for (int i = 0; i < transactionsByCardNumber.size(); i++) {
            transactionDtos.add(transactionConverter.convertToTransactionDto(transactionsByCardNumber.get(i)));
        }
        return transactionDtos;
    }

    @Override
    public List<TransactionDto> findTransactionsByActionCredits(Long cardNumber, String actionCredits) {
        List<TransactionDto> transactionDtos = new ArrayList<>();
        List<Transaction> transactionsByCardNumberAndActionCredits = transactionRepository.findByCardNumberAndTransaction(cardNumber, actionCredits);

        for (int i = 0; i < transactionsByCardNumberAndActionCredits.size(); i++) {
            transactionDtos.add(transactionConverter.convertToTransactionDto(transactionsByCardNumberAndActionCredits.get(i)));
        }
        return transactionDtos;
    }
}
