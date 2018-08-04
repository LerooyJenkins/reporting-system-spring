package com.ceepdode.reportingsystem.service;

import com.ceepdode.reportingsystem.dto.AccountDto;

public interface AccountService {

    AccountDto findAccount (String ownerLogin);

    AccountDto createAccount (AccountDto accountDto);

    AccountDto updateAccount (AccountDto accountDto);

    void deleteAccount (Long accountId);
}
