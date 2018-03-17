package com;


import com.lauracarpaciu.dao.CustomerRepository;
import com.lauracarpaciu.entities.account.Account;
import com.lauracarpaciu.entities.address.Address;
import com.lauracarpaciu.entities.address.AddressType;
import com.lauracarpaciu.entities.bankAccount.CurrentAccount;
import com.lauracarpaciu.entities.creditcard.CreditCard;
import com.lauracarpaciu.entities.creditcard.CreditCardType;
import com.lauracarpaciu.entities.customer.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GestiuneApplicationTests {
	private Logger log = LoggerFactory.getLogger(GestiuneApplicationTests.class);
	@Test
	public void contextLoads() {
	}

	@Autowired
	CustomerRepository customerRepository;

	@Test
	public void customerTest() {
		log.info("*** Starting Customer Test");

		// Create a new account
		Account account = new Account("5", "12345");

		// Create a new customer for the account
		Customer customer = new Customer("Rx224", "Laura","Carpaciu","laura.carpaciu@gmail.com","07255333", account);

		// Create a new credit card for the account
		CreditCard creditCard = new CreditCard("1234567801234567",new CurrentAccount("CC1", 800, 20), CreditCardType.VISA);

		// Add the credit card to the customer's account
		customer.getAccount()
				.getCreditCards()
				.add(creditCard);

		// Create a new shipping address for the customer
		Address address = new Address("Aleea Poaiana Sibiului", null,
				 "Bucuresti", "Romania", 20500, AddressType.SHIPPING);

		// Add address to the customer's account
		customer.getAccount()
				.getAddresses()
				.add(address);

		// Apply the cascading update by persisting the customer object
		customer = customerRepository.save(customer);

		// Query for the customer object to ensure cascading persistence of the object graph
		log.info(customerRepository.findOne(customer.getId()).toString());
	}
}
