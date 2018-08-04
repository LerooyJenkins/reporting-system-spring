package com.ceepdode.reportingsystem.controller;

import com.ceepdode.reportingsystem.dto.AccountDto;
import com.ceepdode.reportingsystem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/api/account/{ownerLogin}")
    public AccountDto findAccount(@PathVariable String ownerLogin) {
        return accountService.findAccount(ownerLogin);
    }

    @PostMapping(value = "/api/account")
    public AccountDto createAccount(@RequestBody AccountDto accountDto) {
        return accountService.createAccount(accountDto);
    }

    @PutMapping(value = "/api/account")
    public AccountDto updateAccount(@RequestBody AccountDto accountDto) {
        return accountService.updateAccount(accountDto);
    }

    @DeleteMapping(value = "/api/account/{accountId}")
    public void deleteAccount(@PathVariable Long accountId) {
        accountService.deleteAccount(accountId);
    }
}
