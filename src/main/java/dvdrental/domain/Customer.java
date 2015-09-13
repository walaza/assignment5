/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdrental.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author bulelani
 */
@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String idNumber;
    @Embedded
    private ContactDetails contacts;
    @Embedded
    private Address address;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private List<Rental> rental;
    @OneToOne(cascade=CascadeType.ALL)
    private Account account;

    private Customer() {
    }

    public Customer(Builder builder) {
        name = builder.name;
        surname = builder.surname;
        idNumber = builder.idNumber;
        contacts = builder.contacts;
        address = builder.address;
        rental = builder.rental;
        account = builder.account;
    }

    public static class Builder {

        private String name;
        private String surname;
        private String idNumber;
        private ContactDetails contacts;
        private Address address;
        private List<Rental> rental;
        private Account account;

        public Builder(String idNumber) {
            this.idNumber = idNumber;
        }

        public Builder name(String value) {
            this.name = value;
            return this;
        }

        public Builder surname(String value) {
            this.surname = value;
            return this;
        }

        public Builder contacts(ContactDetails value) {
            this.contacts = value;
            return this;
        }

        public Builder address(Address value) {
            this.address = value;
            return this;
        }

        public Builder rental(List<Rental> value) {
            this.rental = value;
            return this;
        }

        public Builder account(Account value) {
            this.account = value;
            return this;
        }

        public Builder copy(Customer value) {
            this.idNumber = value.getIdNumber();
            this.name = value.getName();
            this.surname = value.getSurname();
            this.contacts = value.getContacts();
            this.address = value.getAddress();
            this.rental = value.getRental();
            this.account = value.getAccount();
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }

    public Long getId() {
        return id;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dvdrental.domain.Customer[ id=" + id + " ]";
    }

}
