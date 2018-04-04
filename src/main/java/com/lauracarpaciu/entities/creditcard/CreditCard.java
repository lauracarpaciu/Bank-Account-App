package com.lauracarpaciu.entities.creditcard;

import com.lauracarpaciu.entities.account.Account;
import com.lauracarpaciu.entities.bankAccount.CurrentAccount;
import com.lauracarpaciu.entities.data.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "credit-cards")
public class CreditCard extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String number;
    @ManyToOne
    @JoinColumn(name = "bankAccountId")
    private CurrentAccount currentAccount;
    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;
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

    public CurrentAccount getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(CurrentAccount currentAccount) {
        this.currentAccount = currentAccount;
    }

    public CreditCardType getType() {
        return type;
    }

    public void setType(CreditCardType type) {
        this.type = type;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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
