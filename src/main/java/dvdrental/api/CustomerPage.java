/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdrental.api;

import dvdrental.domain.Customer;
import dvdrental.model.CustomerResource;
import dvdrental.services.CustomerService;
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
@RequestMapping(value="/customer/**")
public class CustomerPage {
   @Autowired
   private CustomerService service;
   
   @RequestMapping(value = "/customers", method = RequestMethod.GET)
   public List<CustomerResource> getAllCustomers(){
      List<CustomerResource> hateos = new ArrayList<>();
      List<Customer> customers = service.getCustomers();
      for(Customer customer : customers){
          CustomerResource res = new CustomerResource
                  .Builder(customer.getIdNumber())
                  .account(customer.getAccount())
                  .address(customer.getAddress())
                  .name(customer.getName())
                  .surname(customer.getSurname())
                  .contacts(customer.getContacts())
                  .rental(customer.getRental())
                  .custid(customer.getId())
                  .build();
          Link custommer = new
              Link("http://localhost:8080/customer/"+res.getCustid().toString())
                  .withRel("cus");
          res.add(custommer);
          hateos.add(res);
      }
      return hateos;
   }
}
