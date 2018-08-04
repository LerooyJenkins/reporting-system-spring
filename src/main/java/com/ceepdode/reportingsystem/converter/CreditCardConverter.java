package com.ceepdode.reportingsystem.converter;

import com.ceepdode.reportingsystem.domain.CreditCard;
import com.ceepdode.reportingsystem.dto.CreditCardDto;
import org.springframework.stereotype.Component;

@Component
public class CreditCardConverter {

    public CreditCard convertToCreditCard(CreditCardDto creditCardDto){
        CreditCard creditCard = new CreditCard();
        creditCard.setId(creditCardDto.getId());
        creditCard.setCardNumber(creditCardDto.getCardNumber());
        creditCard.setCredits(creditCardDto.getCredits());
        return creditCard;
    }

    public CreditCardDto convertToCreditCardDto(CreditCard creditCard){
        CreditCardDto creditCardDto = new CreditCardDto();
        creditCardDto.setId(creditCard.getId());
        creditCardDto.setCardNumber(creditCard.getCardNumber());
        creditCardDto.setCredits(creditCardDto.getCredits());
        return creditCardDto;
    }
}
