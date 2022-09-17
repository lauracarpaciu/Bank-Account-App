package com.lauracarpaciu.entities.address;

import com.lauracarpaciu.entities.account.Account;
import com.lauracarpaciu.entities.data.BaseEntity;

import javax.persistence.*;


@Entity
@Table(name = "addresses")
public class Address extends BaseEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String street1;
    private String street2;
    private String city;
    private String country;
    private Integer zipCode;
    @Enumerated(EnumType.STRING)
    private AddressType addressType;
    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;

    public Address(String street1, String street2, String city, String country, Integer zipCode, AddressType addressType, Account account) {

        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
        this.addressType = addressType;
        this.account = account;
    }

    public Address(Long createdAt, Long lastModified) {
        super(createdAt, lastModified);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street1='" + street1 + '\'' +
                ", street2='" + street2 + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", addressType='" + addressType + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
