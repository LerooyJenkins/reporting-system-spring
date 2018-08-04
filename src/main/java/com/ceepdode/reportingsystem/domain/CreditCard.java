package com.ceepdode.reportingsystem.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "credit_card_id_seq")
    @SequenceGenerator(name = "credit_card_id_seq", sequenceName = "credit_card_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JsonIgnore
    private Account account;

    @Column(unique = true)
    private Long cardNumber;

    private Double credits;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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
        if (!(o instanceof CreditCard)) return false;
        CreditCard that = (CreditCard) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getAccount(), that.getAccount()) &&
                Objects.equals(getCardNumber(), that.getCardNumber()) &&
                Objects.equals(getCredits(), that.getCredits());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getAccount(), getCardNumber(), getCredits());
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", account=" + account +
                ", cardNumber=" + cardNumber +
                ", credits=" + credits +
                '}';
    }
}
