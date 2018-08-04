package com.ceepdode.reportingsystem.converter;

import com.ceepdode.reportingsystem.domain.Account;
import com.ceepdode.reportingsystem.domain.CreditCard;
import com.ceepdode.reportingsystem.dto.AccountDto;
import com.ceepdode.reportingsystem.dto.CreditCardDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountConverter {

    public Account convertToAccount(AccountDto accountDto) {
        Account account = new Account();
        account.setId(accountDto.getId());
        account.setOwnerLogin(accountDto.getOwnerLogin());
        account.setFirstName(accountDto.getFirstName());
        account.setLastName(accountDto.getLastName());
        account.setPhoneNumber(accountDto.getPhoneNumber());
        return account;
    }

    public AccountDto convertToAccountDto(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setOwnerLogin(account.getOwnerLogin());
        accountDto.setFirstName(account.getFirstName());
        accountDto.setLastName(account.getLastName());
        accountDto.setPhoneNumber(account.getPhoneNumber());
        accountDto.setCreditCardDtos(convertCreditCardEntityListToCreditCardDtoList(account.getCreditCards()));
        return accountDto;
    }

    private static List<CreditCardDto> convertCreditCardEntityListToCreditCardDtoList(List<CreditCard> creditCards) {
        List<CreditCardDto> creditCardDtos = new ArrayList<>();

        for (int i = 0; i < creditCards.size(); i++) {
            CreditCardDto creditCardDto = new CreditCardDto();
            creditCardDto.setId(creditCards.get(i).getId());
            creditCardDto.setCardNumber(creditCards.get(i).getCardNumber());
            creditCardDto.setCredits(creditCards.get(i).getCredits());

            creditCardDtos.add(creditCardDto);
        }
        return creditCardDtos;
    }
}
