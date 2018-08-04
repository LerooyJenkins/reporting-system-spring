package com.ceepdode.reportingsystem.controller;

import com.ceepdode.reportingsystem.dto.TransactionDto;
import com.ceepdode.reportingsystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping(value = "/api/transactions/{cardNumber}/date-report")
    public List<TransactionDto> findTransactionsByDate(@PathVariable Long cardNumber,
                                                       @RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime from,
                                                       @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime to) {
        return transactionService.findTransactionsByDate(cardNumber, from.toInstant(), to.toInstant());
    }

    @GetMapping(value = "/api/transactions/{cardNumber}")
    public List<TransactionDto> findTransactionsByCardNumber(@PathVariable Long cardNumber) {
        return transactionService.findTransactionsByCardNumber(cardNumber);
    }

    @GetMapping(value = "/api/transactions/{cardNumber}/credit-report")
    public List<TransactionDto> findTransactionsByActionCredits(@PathVariable Long cardNumber,
                                                                @RequestParam("actionCredits") String actionCredits) {
        return transactionService.findTransactionsByActionCredits(cardNumber, actionCredits);
    }
}
