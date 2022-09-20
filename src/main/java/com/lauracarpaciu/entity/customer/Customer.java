package com.lauracarpaciu.entity.customer;

import com.lauracarpaciu.entity.account.Account;
import com.lauracarpaciu.entity.data.BaseEntity;

import javax.persistence.*;


@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String identityCard;
    private String firstName;
    private String lastName;
    private String email;
    private String tel;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accountId")
    private Account account;

    public Customer() {
    }

    public Customer(Long createdAt, Long lastModified, String identityCard, String firstName, String lastName, String email, String tel, Account account) {
        super(createdAt, lastModified);
        this.identityCard = identityCard;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.tel = tel;
        this.account = account;
    }

    public Customer(String identityCard, String firstName, String lastName, String email, String tel, Account account) {
        this.identityCard = identityCard;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.tel = tel;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }


    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", account=" + account +
                "} " + super.toString();
    }
}
