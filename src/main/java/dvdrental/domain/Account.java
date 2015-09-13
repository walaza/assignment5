/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdrental.domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author bulelani
 */
@Entity
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String accountNumber;
    private String status;
    private double balance;
    @OneToOne(cascade=CascadeType.ALL)
    private Subscription subscription;

    private Account() {
    }

    public Account(Builder builder) {
        id = builder.id;
        accountNumber = builder.accountNumber;
        status = builder.status;
        balance = builder.balance;
        subscription = builder.subscription;
    }

    public static class Builder {

        private String accountNumber;
        private String status;
        private double balance;
        private Subscription subscription;
        private Long id;

        public Builder(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        public Builder status(String value) {
            this.status = value;
            return this;
        }

        public Builder balance(double value) {
            this.balance = value;
            return this;
        }

        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder subscription(Subscription value) {
            this.subscription = value;
            return this;
        }

        public Builder copy(Account value) {
            this.accountNumber = value.getAccountNumber();
            this.status = value.getStatus();
            this.balance = value.getBalance();
            this.subscription = value.getSubscription();
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getStatus() {
        return status;
    }

    public double getBalance() {
        return balance;
    }

    public Subscription getSubscription() {
        return subscription;
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
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dvdrental.domain.Account[ id=" + id + " ]";
    }

}
