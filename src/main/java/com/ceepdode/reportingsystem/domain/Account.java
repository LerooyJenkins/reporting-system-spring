package com.ceepdode.reportingsystem.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_id_seq")
    @SequenceGenerator(name = "account_id_seq", sequenceName = "account_id_seq", allocationSize = 1)
    private Long id;

    @Column(unique = true)
    private String ownerLogin;

    private String firstName;
    private String lastName;
    private String phoneNumber;

    @OneToMany(mappedBy = "account")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<CreditCard> creditCards;

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

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equals(getId(), account.getId()) &&
                Objects.equals(getOwnerLogin(), account.getOwnerLogin()) &&
                Objects.equals(getFirstName(), account.getFirstName()) &&
                Objects.equals(getLastName(), account.getLastName()) &&
                Objects.equals(getPhoneNumber(), account.getPhoneNumber()) &&
                Objects.equals(getCreditCards(), account.getCreditCards());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getOwnerLogin(), getFirstName(), getLastName(), getPhoneNumber(), getCreditCards());
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", ownerLogin='" + ownerLogin + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", creditCards=" + creditCards +
                '}';
    }
}
