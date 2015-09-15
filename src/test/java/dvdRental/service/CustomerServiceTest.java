/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdRental.service;

import dvdrental.App;
import dvdrental.conf.factory.AccountFactory;
import dvdrental.conf.factory.AddressFactory;
import dvdrental.conf.factory.ContactFactory;
import dvdrental.conf.factory.CustomerFactory;
import dvdrental.conf.factory.RentalFactory;
import dvdrental.domain.Account;
import dvdrental.domain.Address;
import dvdrental.domain.ContactDetails;
import dvdrental.domain.Customer;
import dvdrental.domain.Rental;
import dvdrental.repository.CustomerRepository;
import dvdrental.services.CustomerService;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 *
 * @author bulelani
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class CustomerServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private CustomerService service;
    private Long id;

    @Autowired
    private CustomerRepository repo;
    private List<Rental> rentals;
    private List<Customer> customers = new ArrayList<>();

    public CustomerServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @org.testng.annotations.Test
    public void create() throws Exception {
        Address address = AddressFactory
                .createAddress("Long street", 8000, "8000");
        Rental rental = RentalFactory
                .createRental("13/09/2015", "20/09/2015", null, 0.00);
        Rental rent = RentalFactory
                .createRental("14/09/2015", "21/09/2015", null, 0.00);
        rentals.add(rental);
        rentals.add(rent);
        Account acc = AccountFactory
                .createAccount("123456", "Active", 250.00, null);
        ContactDetails details = ContactFactory
                .createContact("076589341", null);

        Customer cust = CustomerFactory
                .createCustomer("Thando", "Booi", "900711", details, address, rentals, acc);

        customers.add(cust);
        repo.save(customers);
        id = cust.getId();
        Assert.assertNotNull(cust.getId());
    }
    @org.testng.annotations.Test
    public void testGetCustomers()throws Exception{
        List<Customer> cust = service.getCustomers();
        Assert.assertEquals(cust.size(), 1);
    }
    @org.testng.annotations.Test
    public void testGetCustomerByName() throws Exception{
        Customer cust = service.getCustomerByName("Bulelani");
        Assert.assertNotNull(cust);
    }
}
