package com.lauracarpaciu.entities.creditcard;

import com.lauracarpaciu.entities.bankAccount.BankAccount;
import com.lauracarpaciu.entities.bankAccount.CurrentAccount;
import com.lauracarpaciu.entities.data.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "credit-cards")
public class CreditCard extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    @ManyToOne
    @JoinColumn
    private BankAccount bankAccount=new CurrentAccount();
    @Enumerated(EnumType.STRING)
    private CreditCardType type;

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

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public CreditCardType getType() {
        return type;
    }

    public void setType(CreditCardType type) {
        this.type = type;
    }

    public CreditCard() {
    }


}
