package com.ceepdode.reportingsystem.service;

import com.ceepdode.reportingsystem.converter.CreditCardConverter;
import com.ceepdode.reportingsystem.domain.CreditCard;
import com.ceepdode.reportingsystem.domain.Transaction;
import com.ceepdode.reportingsystem.dto.CreditCardDto;
import com.ceepdode.reportingsystem.repository.AccountRepository;
import com.ceepdode.reportingsystem.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;

@Service
@Transactional
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private CreditCardConverter creditCardConverter;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionService transactionService;

    @Override
    public CreditCardDto findCreditCard(Long cardNumber) {
        if (!creditCardRepository.existsByCardNumber(cardNumber)) {
            throw new RuntimeException("Card with number: " + cardNumber + " - does not exist");
        }

        CreditCard creditCard = creditCardRepository.findByCardNumber(cardNumber);
        return creditCardConverter.convertToCreditCardDto(creditCard);
    }

    @Override
    public CreditCardDto createCreditCard(String ownerLogin, CreditCardDto creditCardDto) {
        if (!creditCardRepository.existsByCardNumber(creditCardDto.getCardNumber())) {
            throw new RuntimeException("Card with number: " + creditCardDto.getCardNumber() + " - does not exist");
        }

        CreditCard creditCard = creditCardConverter.convertToCreditCard(creditCardDto);
        creditCard.setAccount(accountRepository.findByOwnerLogin(ownerLogin));

        CreditCard creditCardCreated = creditCardRepository.save(creditCard);
        return creditCardConverter.convertToCreditCardDto(creditCardCreated);
    }

    @Override
    public CreditCardDto updateCreditCard(String ownerLogin, CreditCardDto creditCardDto) {
        if (!creditCardRepository.existsByCardNumber(creditCardDto.getCardNumber())) {
            throw new RuntimeException("Card with number: " + creditCardDto.getCardNumber() + " - does not exist");
        }

        CreditCard creditCardInput = creditCardConverter.convertToCreditCard(creditCardDto);
        CreditCard creditCardinDataBase = creditCardRepository.getByCardNumber(creditCardDto.getCardNumber());
        creditCardinDataBase.setCardNumber(creditCardInput.getCardNumber());

        return creditCardConverter.convertToCreditCardDto(creditCardRepository.save(creditCardinDataBase));
    }

    @Override
    public void deleteCreditCard(Long cardNumber) {
        if (!creditCardRepository.existsByCardNumber(cardNumber)) {
            throw new RuntimeException("Card with number: " + cardNumber + " - does not exist");
        }
        creditCardRepository.getByCardNumber(cardNumber);
    }

    @Override
    public Double getBalance(Long cardNumber) {
        if (!creditCardRepository.existsByCardNumber(cardNumber)) {
            throw new RuntimeException("Card with number: " + cardNumber + " - does not exist");
        }

        return creditCardRepository.findCreditsByCardNumber(cardNumber);
    }

    @Override
    public Double getCredits(Long cardNumber, Double creditsToGet) {
        if (!creditCardRepository.existsByCardNumber(cardNumber)) {
            throw new RuntimeException("Card with number: " + cardNumber + " - does not exist");
        }

        CreditCard creditCard = creditCardRepository.getByCardNumber(cardNumber);
        if (creditsToGet > creditCard.getCredits()) {
            throw new RuntimeException("Limit is exceeded");
        }

        Double balance = creditCard.getCredits();
        creditCard.setCredits(balance - creditsToGet);

        doTransaction(cardNumber,"-"+creditsToGet);
        creditCardRepository.save(creditCard);


        return creditCard.getCredits();
    }

    @Override
    public Double putCredits(Long cardNumber, Double creditsToPut) {
        if (!creditCardRepository.existsByCardNumber(cardNumber)) {
            throw new RuntimeException("Card with number: " + cardNumber + " - does not exist");
        }

        CreditCard creditCard = creditCardRepository.getByCardNumber(cardNumber);

        Double balance = creditCard.getCredits();
        creditCard.setCredits(balance + creditsToPut);

        doTransaction(cardNumber,"+"+creditsToPut);
        creditCardRepository.save(creditCard);


        return creditCard.getCredits();
    }

    private void doTransaction(Long cardNumber, String actionCredits){
        Transaction transaction = new Transaction();
        transaction.setTransactionDate(Instant.now());
        transaction.setCardNumber(cardNumber);
        transaction.setTransaction(actionCredits);

        transactionService.createTransaction(transaction);
    }
}
