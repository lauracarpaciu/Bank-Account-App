package com.lauracarpaciu.entities.bankAccount;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

@Entity
@DiscriminatorValue("SC")
@XmlType(name = "SC")
public class SavingAccount extends BankAccount {
    private double taxes;

    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    public SavingAccount() {
    }

    public SavingAccount(String accountName, double balance, double taxes) {
        super(accountName, balance);
        this.taxes = taxes;
    }
}
