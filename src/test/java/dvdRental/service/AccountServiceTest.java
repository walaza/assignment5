/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dvdRental.service;

import dvdrental.App;
import dvdrental.conf.factory.AccountFactory;
import dvdrental.conf.factory.SubscriptionFactory;
import dvdrental.domain.Account;
import dvdrental.domain.Subscription;
import dvdrental.repository.AccountRepository;
import dvdrental.services.AccountService;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * 
 * @author bulelani
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class AccountServiceTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private AccountService service;
    private Long id;
    
    @Autowired
    private AccountRepository repository;
    @org.testng.annotations.Test
    public void testCreate() throws Exception{
        Subscription subscription = SubscriptionFactory
                .createSubscription("monthly", 100.00);
        Subscription subscription1 = SubscriptionFactory
                .createSubscription("weekly", 50.00);
        
        Account account = AccountFactory
                .createAccount("1552384", "Active", 200.00, subscription);
        
        Account account1 = AccountFactory
                .createAccount("25552384", "Active", 100.00, subscription1);
        
        repository.save(account);
        id = account.getId();
        
        repository.save(account1);
        id = account1.getId();
        
        Assert.assertNotNull(account.getId());
        Assert.assertNotNull(account1.getId());
    }
    @org.testng.annotations.Test
    public void testGetAccounts() throws Exception{
        List<Account> account = service.getAccounts();
        Assert.assertEquals(2, account.size());
    }
}