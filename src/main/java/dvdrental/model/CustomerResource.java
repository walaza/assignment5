/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdrental.model;

import dvdrental.domain.Account;
import dvdrental.domain.Address;
import dvdrental.domain.ContactDetails;
import dvdrental.domain.Rental;
import java.util.List;
import org.springframework.hateoas.ResourceSupport;

/**
 *Customer createCustomer(String name, String surname, String idNumber, ContactDetails contacts,
            Address address, List<Rental> rentals, Account account)
 * @author bulelani
 */
public class CustomerResource extends ResourceSupport{
    private Long custid;
    private String name;
    private String surname;
    private String idNumber;
    private ContactDetails contacts;
    private Address address;
    private List<Rental> rental;
    private Account account;
    
    private CustomerResource(){
        
    }
    public CustomerResource(Builder builder){
        this.custid = builder.custid;
        this.account = builder.account;
        this.address = builder.address;
        this.name = builder.name;
        this.surname = builder.surname;
        this.idNumber = builder.idNumber;
        this.rental = builder.rental;
        this.contacts = builder.contacts;
    }
    public static class Builder{
        private Long custid;
        private Account account;
        private Address address;
        private String name;
        private String surname;
        private String idNumber;
        private List<Rental> rental;
        private ContactDetails contacts;
        
        public Builder(String idNumber){
            this.idNumber = idNumber;
        }
        public Builder custid(Long value){
            this.custid = value;
            return this;
        }
        public Builder account(Account value){
            this.account = value;
            return this;
        }
        public Builder address(Address value){
           this.address = value;
           return this;
        }
        public Builder name(String value){
            this.name = value;
            return this;
        }
        public Builder surname(String value){
            this.surname = value;
            return this;
        }
        public Builder rental(List<Rental> value){
            this.rental = value;
            return this;
        }
        public Builder contacts(ContactDetails value){
            this.contacts = value;
            return this;
        }
        public Builder copy(CustomerResource value){
            this.account = value.getAccount();
            this.address = value.getAddress();
            this.contacts = value.getContacts();
            this.custid = value.getCustid();
            this.idNumber = value.getIdNumber();
            this.name = value.getName();
            this.rental = value.getRental();
            this.surname = value.getSurname();
            return this;
        }
        public CustomerResource build(){
            return new CustomerResource(this);
        }
    }

    public Long getCustid() {
        return custid;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public ContactDetails getContacts() {
        return contacts;
    }

    public Address getAddress() {
        return address;
    }

    public List<Rental> getRental() {
        return rental;
    }

    public Account getAccount() {
        return account;
    }
    
}
