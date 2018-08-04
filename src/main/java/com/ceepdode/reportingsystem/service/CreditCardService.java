package com.ceepdode.reportingsystem.service;

import com.ceepdode.reportingsystem.dto.CreditCardDto;

public interface CreditCardService {

    CreditCardDto findCreditCard(Long cardNumber);

    CreditCardDto createCreditCard(String ownerLogin, CreditCardDto creditCardDto);

    CreditCardDto updateCreditCard (String ownerLogin, CreditCardDto creditCardDto);

    void deleteCreditCard(Long cardNumber);

    Double getBalance (Long cardNumber);

    Double getCredits(Long cardNumber, Double creditsToGet);

    Double putCredits(Long cardNumber, Double creditsToPut);
}
