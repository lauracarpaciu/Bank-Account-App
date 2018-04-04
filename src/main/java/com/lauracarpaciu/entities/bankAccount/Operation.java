package com.lauracarpaciu.entities.bankAccount;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.lauracarpaciu.entities.data.BaseEntity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(length = 2)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(name = "V", value = Payment.class),
        @JsonSubTypes.Type(name = "R", value = Withdrawal.class)})
public abstract class Operation extends BaseEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long operationNumber;
    private double amount;
    @ManyToOne
    @JoinColumn(name="bankAccountId")
    private BankAccount account;
    @ManyToOne
    @JoinColumn(name="employeeId")
    private Employee employee;

    public Operation() {
        super();
    }

    public Operation(Date dateOperation, double amount) {
        super();
        this.amount = amount;
    }

    public Long getOperationNumber() {
        return operationNumber;
    }

    public void setOperationNumber(Long operationNumber) {
        this.operationNumber = operationNumber;
    }



    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    @JsonIgnore
    @XmlTransient
    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }
    @JsonIgnore
    @XmlTransient
    public Employee getEmployee() {
        return employee;
    }

    @JsonSetter
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

