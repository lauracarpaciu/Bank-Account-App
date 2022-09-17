package com.lauracarpaciu.entities.account;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lauracarpaciu.entities.address.Address;
import com.lauracarpaciu.entities.bankAccount.BankAccount;
import com.lauracarpaciu.entities.creditcard.CreditCard;
import com.lauracarpaciu.entities.data.BaseEntity;
import com.lauracarpaciu.entities.order.Order;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "accounts")
public class Account extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userId;
    private String accountNumber;
    private Boolean defaultAccount;
    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private Collection<CreditCard> creditCards;
    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private Collection<BankAccount> bankAccounts;
    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private Collection<Address> addresses;
    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private Collection<Order> orders;

    public Account() {
    }

    public Account(Long createdAt, Long lastModified, String userId, String accountNumber) {
        super();
        this.userId = userId;
        this.accountNumber = accountNumber;
    }

    public Account(String userId, String accountNumber) {
        this.userId = userId;
        this.accountNumber = accountNumber;
    }

    @JsonIgnore
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
    public Collection<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(Collection<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    @JsonIgnore
    public Collection<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(Collection<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    @JsonIgnore
    public Collection<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Collection<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id + ", accountNumber='" + accountNumber + '\'' + ", creditCards=" + creditCards + ", addresses=" + addresses + "} " + super.toString();
    }


}
