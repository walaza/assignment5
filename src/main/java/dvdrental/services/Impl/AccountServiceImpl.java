/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dvdrental.services.Impl;

import dvdrental.domain.Account;
import dvdrental.repository.AccountRepository;
import dvdrental.services.AccountService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bulelani
 */
@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    AccountRepository repository;
    @Override
    public List<Account> getAccounts() {
        List<Account> allaccounts = new ArrayList<>();
        
        Iterable<Account> accounts = repository.findAll();
        for(Account account : accounts){
            allaccounts.add(account);
        }
        return allaccounts;
    }
    
}
