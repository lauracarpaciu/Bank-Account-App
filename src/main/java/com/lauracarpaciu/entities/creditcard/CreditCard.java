package com.lauracarpaciu.entities.creditcard;

import com.lauracarpaciu.entities.bankAccount.BankAccount;
import com.lauracarpaciu.entities.bankAccount.CurrentAccount;
import com.lauracarpaciu.entities.data.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "credit-cards")
public class CreditCard extends BaseEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;

    public CurrentAccount getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(CurrentAccount currentAccount) {
        this.currentAccount = currentAccount;
    }

    @ManyToOne
    @JoinColumn(name="bankAccountId")
    private CurrentAccount currentAccount;
    @Enumerated(EnumType.STRING)
    private CreditCardType type;

    public CreditCard(String number, CurrentAccount currentAccount) {
    }

    public CreditCard(String number, CurrentAccount bankAccount, CreditCardType type) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }



    public CreditCardType getType() {
        return type;
    }

    public void setType(CreditCardType type) {
        this.type = type;
    }

    public CreditCard() {
    }

    public CreditCard(Long createdAt, Long lastModified, String number, CurrentAccount currentAccount, CreditCardType type) {
        super(createdAt, lastModified);
        this.number = number;
        this.currentAccount = currentAccount;
        this.type = type;
    }
}
