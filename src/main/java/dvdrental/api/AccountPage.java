/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdrental.api;

import dvdrental.domain.Account;
import dvdrental.model.AccountResource;
import dvdrental.services.AccountService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bulelani
 */
@RestController
@RequestMapping(value="/account/**")
public class AccountPage {
    @Autowired
    private AccountService service;
    
    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public List<AccountResource> getAllAccounts(){
       List<AccountResource> hateos = new ArrayList<>();
       List<Account> accounts = service.getAccounts();
       for(Account account : accounts){
           AccountResource res = new AccountResource
                   .Builder(account.getAccountNumber())
                   .status(account.getStatus())
                   .balance(account.getBalance())
                   .subscription(account.getSubscription())
                   .accid(account.getId())
                   .build();
           Link acounts = new 
               Link("http://localhost:8080/account/"+res.getAccid().toString())
                   .withRel("acc");
           res.add(acounts);
           hateos.add(res);
       }
       return hateos;
    }
}
