package com.ceepdode.reportingsystem.controller;

import com.ceepdode.reportingsystem.dto.CreditCardDto;
import com.ceepdode.reportingsystem.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

    @GetMapping(value = "/api/card/{cardNumber}")
    public CreditCardDto findCreditCard(@PathVariable Long cardNumber) {
        return creditCardService.findCreditCard(cardNumber);
    }

    @PostMapping(value = "/api/card/{ownerLogin}")
    public CreditCardDto createCreditCard(@PathVariable String ownerLogin,
                                          @RequestBody CreditCardDto creditCardDto) {
        return creditCardService.createCreditCard(ownerLogin, creditCardDto);
    }

    @PutMapping(value = "/api/card/{ownerLogin}")
    public CreditCardDto updateCreditCard(@PathVariable String ownerLogin,
                                          @RequestBody CreditCardDto creditCardDto) {
        return creditCardService.updateCreditCard(ownerLogin, creditCardDto);
    }

    @DeleteMapping(value = "/api/card/{cardNumber}")
    public void deleteCreditCard(@PathVariable Long cardNumber) {
        creditCardService.deleteCreditCard(cardNumber);
    }

    @GetMapping(value = "/api/card/{cardNumber}/balance")
    public Double getBalance(@PathVariable Long cardNumber) {
        return creditCardService.getBalance(cardNumber);
    }

    @PostMapping(value = "/api/card/{cardNumber}/{creditsToGet}")
    public Double getCredits(@PathVariable Long cardNumber,
                             @PathVariable Double creditsToGet) {
        return creditCardService.getCredits(cardNumber, creditsToGet);
    }

    @PutMapping(value = "/api/card/{cardNumber}/{creditsToPut}")
    public Double putCredits(@PathVariable Long cardNumber,
                             @PathVariable Double creditsToPut) {
        return creditCardService.putCredits(cardNumber, creditsToPut);
    }
}
