package com.lauracarpaciu.entities.bankAccount;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

@Entity
@DiscriminatorValue("CC")
@XmlType(name = "CC")
public class CurrentAccount extends BankAccount {
    private double discovered;
    public CurrentAccount() {
        super();
    }

    public CurrentAccount(String accountName, double balance, double discovered) {
        super(accountName, balance);
        this.discovered = discovered;
    }

    public double getDiscovered() {
        return discovered;
    }

    public void setDiscovered(double discovered) {
        this.discovered = discovered;
    }
}
