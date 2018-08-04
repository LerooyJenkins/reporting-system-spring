package com.ceepdode.reportingsystem.dto;

import com.ceepdode.reportingsystem.domain.CreditCard;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

public class AccountDto {

    private Long id;
    private String ownerLogin;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    private List<CreditCardDto> creditCardDtos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwnerLogin() {
        return ownerLogin;
    }

    public void setOwnerLogin(String ownerLogin) {
        this.ownerLogin = ownerLogin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<CreditCardDto> getCreditCardDtos() {
        return creditCardDtos;
    }

    public void setCreditCardDtos(List<CreditCardDto> creditCardDtos) {
        this.creditCardDtos = creditCardDtos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountDto)) return false;
        AccountDto that = (AccountDto) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getOwnerLogin(), that.getOwnerLogin()) &&
                Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getLastName(), that.getLastName()) &&
                Objects.equals(getPhoneNumber(), that.getPhoneNumber()) &&
                Objects.equals(getCreditCardDtos(), that.getCreditCardDtos());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getOwnerLogin(), getFirstName(), getLastName(), getPhoneNumber(), getCreditCardDtos());
    }

    @Override
    public String toString() {
        return "AccountDto{" +
                "id=" + id +
                ", ownerLogin='" + ownerLogin + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", creditCardDtos=" + creditCardDtos +
                '}';
    }
}
