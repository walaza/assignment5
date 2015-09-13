/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dvdRental.domain;

import dvdrental.conf.factory.AccountFactory;
import dvdrental.domain.Account;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author bulelani
 */
public class AccountTest {
   @org.testng.annotations.Test
   public void testCreate() throws Exception{
       Account account = AccountFactory
               .createAccount("158963", "Active", 20.00, null);
       Assert.assertEquals("158963", account.getAccountNumber());
   }
   @org.testng.annotations.Test
   public void testUpdate() throws Exception{
       Account account = AccountFactory
               .createAccount("158963", "Active", 20.00, null);
       Assert.assertEquals("158963", account.getAccountNumber()); 
       
       Account copiedaccount = new Account
               .Builder("158963").copy(account).status("Inactive").balance(20.00).subscription(null).build();
       
       Assert.assertEquals("158963", account.getAccountNumber());
       Assert.assertEquals("158963", copiedaccount.getAccountNumber());
       Assert.assertEquals("Active", account.getStatus());
       Assert.assertEquals("Inactive", copiedaccount.getStatus());
   }
}
