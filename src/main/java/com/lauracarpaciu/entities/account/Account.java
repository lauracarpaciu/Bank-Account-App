package com.lauracarpaciu.entities.account;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lauracarpaciu.entities.address.Address;
import com.lauracarpaciu.entities.bankAccount.BankAccount;
import com.lauracarpaciu.entities.creditcard.CreditCard;
import com.lauracarpaciu.entities.data.BaseEntity;
import com.lauracarpaciu.entities.order.Order;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Collection;

@Entity
@Table(name = "accounts")
public class Account extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String accountNumber;
    private Boolean defaultAccount;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<CreditCard> creditCards;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<BankAccount> bankAccounts;
    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private Collection<Address> addresses;
    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private Collection<Order> orders;

    public Account() {
    }

    public Account(Long createdAt, Long lastModified, String userId, String accountNumber) {
        super(createdAt, lastModified);
        this.userId = userId;
        this.accountNumber = accountNumber;
    }

    @JsonIgnore
    @XmlTransient
    public Collection<Order> getOrders() {
        return orders;
    }

    public void setOrders(Collection<Order> orders) {
        this.orders = orders;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Boolean getDefaultAccount() {
        return defaultAccount;
    }

    public void setDefaultAccount(Boolean defaultAccount) {
        this.defaultAccount = defaultAccount;
    }
    @JsonIgnore
    @XmlTransient
    public Collection<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(Collection<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }
    @JsonIgnore
    @XmlTransient
    public Collection<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(Collection<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
    @JsonIgnore
    @XmlTransient
    public Collection<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Collection<Address> addresses) {
        this.addresses = addresses;
    }


}
