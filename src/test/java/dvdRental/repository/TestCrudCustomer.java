/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dvdRental.repository;

import dvdrental.App;
import dvdrental.conf.factory.CustomerFactory;
import dvdrental.domain.Account;
import dvdrental.domain.Address;
import dvdrental.domain.ContactDetails;
import dvdrental.domain.Customer;
import dvdrental.domain.Rental;
import dvdrental.repository.CustomerRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

/**
 *
 * @author bulelani
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudCustomer extends AbstractTestNGSpringContextTests{
     private Long id;
     
    @Autowired
    CustomerRepository repository;
    
     @org.testng.annotations.Test(enabled = true)
     public void create() {
        List<Customer> customers = new ArrayList<>();
        List<Rental> rentals = new ArrayList<>();
        
        Account acc = new Account.Builder("123456")
                .balance(50.00)
                .status("Active")
                .subscription(null)
                .build();
        
        Address addr = new Address.Builder("Strand")
                .code(8000)
                .postalAddress("8000")
                .build();
        ContactDetails details = new ContactDetails.Builder("0786030795")
                .homeNumber("021369852")
                .build();
        Rental rent = new Rental.Builder("12/9/2015")
                .dueDate("15/09/2015")
                .build();
        rentals.add(rent);
        
        Customer cust = CustomerFactory
                .createCustomer("Bulelani", "Walaza", "901229", details, addr, rentals, acc);
        
        customers.add(cust);
        
        repository.save(customers);
        id = cust.getId();
        Assert.assertNotNull(cust.getId());
    }
     
    @org.testng.annotations.Test(dependsOnMethods = "create")
    public void read() throws Exception{
        Customer cust = repository.findOne(id);
        Assert.assertEquals("901229", cust.getIdNumber());
    }
    
    @org.testng.annotations.Test(dependsOnMethods = "read")
    public void update() throws Exception{
        Customer cust = repository.findOne(id);
        Customer newCustomer = new Customer.Builder("901229")
                .name("Bulelani").surname("Walaza").account(null).address(null)
                .contacts(null).rental(null).build();
        repository.save(newCustomer);
        Assert.assertEquals("9012295", cust.getIdNumber());
    }
    
   @org.testng.annotations.Test(dependsOnMethods = "update")
    public void testDelete() throws Exception{
        Customer cust = repository.findOne(id);
        repository.delete(cust);
        Customer newCustomer = repository.findOne(id);
        Assert.assertNull(newCustomer);
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
