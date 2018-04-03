package com.lauracarpaciu.entities.bankAccount;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.lauracarpaciu.entities.account.Account;
import com.lauracarpaciu.entities.customer.Customer;
import com.lauracarpaciu.entities.data.BaseEntity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Collection;

@Entity
@Table(name = "bankaccounts")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_CPTE", discriminatorType = DiscriminatorType.STRING, length = 2)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(name = "CC", value = CurrentAccount.class), @JsonSubTypes.Type(name = "SC", value = SavingAccount.class)})
@XmlSeeAlso({CurrentAccount.class, SavingAccount.class})
public abstract class BankAccount extends BaseEntity  {
    @Id
    private String accountName;
    private double balance;
    @ManyToOne
    @JoinColumn(name="customerId")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name="employeeId")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;
    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private Collection<Operation> operations;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @JsonIgnore
    @XmlTransient
    public Collection<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Collection<Operation> operations) {
        this.operations = operations;
    }

    public BankAccount() {
    }

    public BankAccount(String accountName, double balance) {
        this.accountName = accountName;
        this.balance = balance;
    }
}
