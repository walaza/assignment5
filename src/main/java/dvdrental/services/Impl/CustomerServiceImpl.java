/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdrental.services.Impl;

import dvdrental.domain.Customer;
import dvdrental.repository.CustomerRepository;
import dvdrental.services.CustomerService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bulelani
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repository;

    @Override
    public List<Customer> getCustomers() {
        List<Customer> allcustomers = new ArrayList<>();

        Iterable<Customer> customers = repository.findAll();
        for (Customer customer : customers) {
            allcustomers.add(customer);
        }
        return allcustomers;
    }

    @Override
    public Customer getCustomerByName(String name) {
        List<Customer> customers = new ArrayList<>();
        Customer result = null;

        for (Customer cust : customers) {
            if (cust.getName().contains(name)) {
              result = cust;  
            }
            break;
        }
         if(result == null)
            System.out.print("Sorry no customer found");
        return result;
    }

}
