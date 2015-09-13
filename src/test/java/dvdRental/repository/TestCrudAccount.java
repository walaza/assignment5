/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dvdRental.repository;


import dvdrental.App;
import dvdrental.conf.factory.AccountFactory;
import dvdrental.domain.Account;
import dvdrental.repository.AccountRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author bulelani
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudAccount extends AbstractTestNGSpringContextTests{
     private Long id;
     
     @Autowired
     private AccountRepository repo;

    @org.testng.annotations.Test(enabled = true)
    public void create() {
       List<Account> accounts = new ArrayList<>();
       Account account = new Account.Builder("123456")
                .balance(150)
                .build();
       
        accounts.add(account);
        
        repo.save(accounts);
        id = account.getId();
        
        Assert.assertNotNull(account.getId());
        Assert.assertEquals("123456", account.getAccountNumber());
        
    }
   @org.testng.annotations.Test(dependsOnMethods = "create")
    public void read() throws Exception{
        Account account = repo.findOne(id);
        Assert.assertEquals("123456", account.getAccountNumber());
    }
    @org.testng.annotations.Test(dependsOnMethods = "read")
    public void update() throws Exception{
        Account account = repo.findOne(id);
        Account newAccount = new Account.Builder("1234567")
                .balance(150)
                .build();
        repo.save(newAccount);
        Assert.assertEquals("1234567", newAccount.getAccountNumber());
        Assert.assertEquals(150, 150);
    }
    @org.testng.annotations.Test(dependsOnMethods = "update")
    public void testDelete() throws Exception{
        Account account = repo.findOne(id);
        repo.delete(account);
        Account newAccount = repo.findOne(id);
        Assert.assertNull(newAccount);
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
