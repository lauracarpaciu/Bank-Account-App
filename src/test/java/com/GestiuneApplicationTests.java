package com;


import com.lauracarpaciu.dao.*;
import com.lauracarpaciu.entity.App.GestiuneApplication;
import com.lauracarpaciu.entity.account.Account;
import com.lauracarpaciu.entity.address.Address;
import com.lauracarpaciu.entity.address.AddressType;
import com.lauracarpaciu.entity.bankAccount.*;
import com.lauracarpaciu.entity.catalog.Category;
import com.lauracarpaciu.entity.creditcard.CreditCard;
import com.lauracarpaciu.entity.creditcard.CreditCardType;
import com.lauracarpaciu.entity.customer.Customer;
import com.lauracarpaciu.entity.product.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "test")
@SpringBootTest(classes = GestiuneApplication.class)
public class GestiuneApplicationTests {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private AccountRepository account;
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    private Logger log = LoggerFactory.getLogger(GestiuneApplicationTests.class);

    @Test
    public void contextLoads() {
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void customerTest() {
        log.info("Customer Test");

        Account account = new Account("5", "12345");
        Customer customer = new Customer("Rx224", "Laura", "Carpaciu", "laura.carpaciu@gmail.com", "07255333", account);

        CreditCard creditCard = new CreditCard("1234567801234567", new CurrentAccount("CC1", 800, 20), CreditCardType.VISA);

        customer.getAccount()
                .getCreditCards()
                .add(creditCard);

        Address address = new Address("Aleea Poaiana Sibiului", null,
                "Bucuresti", "Romania", 20500, AddressType.SHIPPING, account);

        customer.getAccount()
                .getAddresses()
                .add(address);
        customer = customerRepository.save(customer);
        log.info(customerRepository.findOne(customer.getId()).toString());
    }


    @Test
    public void test11() {
        try {

            List<Customer> cts1 = customerRepository.findAll();
            assertTrue(cts1.isEmpty());
        } catch (Exception e) {
            assertTrue(e.getMessage(), false);
        }
    }


    @Test
    public void test21() {
        try {

            List<Employee> cts1 = employeeRepository.findAll();
            assertTrue(cts1.isEmpty());
        } catch (Exception e) {
            assertTrue(e.getMessage(), false);
        }
    }


    @Test
    public void test22() {
        try {
            List<Employee> cts1 = employeeRepository.findAll();
            employeeRepository.save(new Employee("E1"));
            employeeRepository.save(new Employee("E2"));
            employeeRepository.save(new Employee("E3"));
            List<Employee> cts2 = employeeRepository.findAll();
            assertTrue(cts1.size() + 3 == cts2.size());
        } catch (Exception e) {
            assertTrue(e.getMessage(), false);
        }
    }

    @Test
    public void test31() {
        try {

            List<Group> cts1 = groupRepository.findAll();
            assertTrue(cts1.isEmpty());
        } catch (Exception e) {
            assertTrue(e.getMessage(), false);
        }
    }

    @Test
    public void test32() {
        try {
            List<Group> cts1 = groupRepository.findAll();
            groupRepository.save(new Group("G1"));
            groupRepository.save(new Group("G2"));
            groupRepository.save(new Group("G3"));
            List<Group> cts2 = groupRepository.findAll();
            assertTrue(cts1.size() + 3 == cts2.size());
        } catch (Exception e) {
            assertTrue(e.getMessage(), false);
        }
    }

    @Test
    public void test41() {
        try {
            List<Account> cts1 = account.findAll();
            assertTrue(cts1.isEmpty());
        } catch (Exception e) {
            assertTrue(e.getMessage(), false);
        }
    }

    @Test
    public void test42() {
        try {
            List<BankAccount> cts1 = bankAccountRepository.findAll();
            bankAccountRepository.save(new CurrentAccount("CC1", 800, 20));
            bankAccountRepository.save(new SavingAccount("SC1", 600, 7.5));
            List<Account> cts2 = account.findAll();
            assertTrue(cts1.size() + 2 == cts2.size());
        } catch (Exception e) {
            assertTrue(e.getMessage(), false);
        }
    }


    @Test
    public void test51() {
        try {

            List<Operation> cts1 = operationRepository.findAll();
            assertTrue(cts1.isEmpty());
        } catch (Exception e) {
            assertTrue(e.getMessage(), false);
        }
    }

    @Test
    public void test52() {
        try {

            List<Operation> cts1 = operationRepository.findAll();
            operationRepository.save(new Payment());
            operationRepository.save(new Withdrawal());
            List<Operation> cts2 = operationRepository.findAll();
            assertTrue(cts1.size() + 2 == cts2.size());
        } catch (Exception e) {
            assertTrue(e.getMessage(), false);
        }

    }

    @Test
    public void test1() {
        try {

            List<Category> cts1 = categoryRepository.findAll();
            categoryRepository.save(new Category("laptop", "lapppppppp", null, "image1.jsp"));
            categoryRepository.save(new Category("Imprimantes", "imppppppppp", null, "image2.jsp"));
            List<Category> cts2 = categoryRepository.findAll();
            Assert.assertTrue(cts1.size() + 2 == cts2.size());
        } catch (Exception e) {
            Assert.assertTrue(e.getMessage(), false);
        }
    }

    @Test
    public void test2() {
        try {

            List<Product> cts1 = productRepository.findAll();
            productRepository.save(new Product("Imprimanta", "Imprimanta", 5000.00, false, null, 1, new Category()));
            productRepository.save(new Product("Imprimanta", "Imprimanta", 5000.00, false, null, 1, new Category()));
            List<Product> cts2 = productRepository.findAll();
            Assert.assertTrue(cts1.size() + 2 == cts2.size());
        } catch (Exception e) {
            Assert.assertTrue(e.getMessage(), false);
        }
    }


}
