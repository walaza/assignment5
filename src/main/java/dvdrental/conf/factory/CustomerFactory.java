/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dvdrental.conf.factory;

import dvdrental.domain.Account;
import dvdrental.domain.Address;
import dvdrental.domain.ContactDetails;
import dvdrental.domain.Customer;
import dvdrental.domain.Rental;
import java.util.List;

/**
 *
 * @author bulelani
 */
public class CustomerFactory {
    public static Customer createCustomer(String name, String surname, String idNumber, ContactDetails contacts,
            Address address, List<Rental> rentals, Account account){
     
        Customer customer = new Customer
                .Builder(idNumber)
                .name(name)
                .surname(surname)
                .contacts(contacts)
                .address(address)
                .rental(rentals)
                .account(account)
                .build();
        return customer;
    }
}
