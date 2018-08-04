package com.ceepdode.reportingsystem.service;

import com.ceepdode.reportingsystem.converter.AccountConverter;
import com.ceepdode.reportingsystem.domain.Account;
import com.ceepdode.reportingsystem.dto.AccountDto;
import com.ceepdode.reportingsystem.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountConverter accountConverter;

    @Override
    public AccountDto findAccount(String ownerLogin) {
        if (!accountRepository.existsByOwnerLogin(ownerLogin)){
            throw new RuntimeException("Account by login: "+ownerLogin+"does not exists");
        }

        Account account = accountRepository.findByOwnerLogin(ownerLogin);
        return accountConverter.convertToAccountDto(account);
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        if (!accountRepository.existsByOwnerLogin(accountDto.getOwnerLogin())){
            throw new RuntimeException("Account by login: "+accountDto.getOwnerLogin()+"does not exists");
        }

        Account account = accountConverter.convertToAccount(accountDto);
        Account accountCreated = accountRepository.save(account);

        return accountConverter.convertToAccountDto(accountCreated);
    }

    @Override
    public AccountDto updateAccount(AccountDto accountDto) {
        if (!accountRepository.existsByOwnerLogin(accountDto.getOwnerLogin())){
            throw new RuntimeException("Account by login: "+accountDto.getOwnerLogin()+"does not exists");
        }

        Account accountInDataBase = accountRepository.findByOwnerLogin(accountDto.getOwnerLogin());
        Account accountInput = accountConverter.convertToAccount(accountDto);

        accountInDataBase.setFirstName(accountInput.getFirstName());
        accountInDataBase.setLastName(accountInput.getLastName());
        accountInDataBase.setPhoneNumber(accountInput.getPhoneNumber());

        return accountConverter.convertToAccountDto(accountRepository.save(accountInDataBase));
    }

    @Override
    public void deleteAccount(Long accountId) {
        if (!accountRepository.existsById(accountId)){
            throw new RuntimeException("Account by id: "+accountId+"does not exists");
        }
        accountRepository.deleteById(accountId);
    }
}
