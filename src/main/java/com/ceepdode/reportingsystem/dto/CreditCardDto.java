package com.ceepdode.reportingsystem.dto;

import com.ceepdode.reportingsystem.domain.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

public class CreditCardDto {

    private Long id;

    @JsonIgnore
    private AccountDto accountDto;

    @Column(unique = true)
    private Long cardNumber;

    private Double credits;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountDto getAccountDto() {
        return accountDto;
    }

    public void setAccountDto(AccountDto accountDto) {
        this.accountDto = accountDto;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Double getCredits() {
        return credits;
    }

    public void setCredits(Double credits) {
        this.credits = credits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreditCardDto)) return false;
        CreditCardDto that = (CreditCardDto) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getAccountDto(), that.getAccountDto()) &&
                Objects.equals(getCardNumber(), that.getCardNumber()) &&
                Objects.equals(getCredits(), that.getCredits());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getAccountDto(), getCardNumber(), getCredits());
    }

    @Override
    public String toString() {
        return "CreditCardDto{" +
                "id=" + id +
                ", accountDto=" + accountDto +
                ", cardNumber=" + cardNumber +
                ", credits=" + credits +
                '}';
    }
}
