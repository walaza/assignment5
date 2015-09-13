/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dvdrental.conf.factory;

import dvdrental.domain.Account;
import dvdrental.domain.Subscription;

/**  
 *
 * @author bulelani
 */
public class AccountFactory {
   public static Account createAccount(String accountNumber, String status, double balance, Subscription subscription){
      
       Account account = new Account
               .Builder(accountNumber)
               .status(status)
               .balance(balance)
               .subscription(subscription)
               .build();
       return account;
   }
}
