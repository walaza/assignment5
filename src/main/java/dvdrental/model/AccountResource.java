/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdrental.model;

import dvdrental.domain.Subscription;
import org.springframework.hateoas.ResourceSupport;

/*
 * @author bulelani
 */
public class AccountResource extends ResourceSupport {

    private Long accid;
    private String accountNumber;
    private String status;
    private double balance;
    private Subscription subscription;

    public Long getAccid() {
        return accid;
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

    private AccountResource() {

    }

    public AccountResource(Builder builder) {
        this.accid = builder.accid;
        this.accountNumber = builder.accountNumber;
        this.balance = builder.balance;
        this.status = builder.status;
        this.subscription = builder.subscription;
    }

    public static class Builder {

        private Long accid;
        private String accountNumber;
        private double balance;
        private String status;
        private Subscription subscription;

        public Builder(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        public Builder accid(Long value) {
            this.accid = value;
            return this;
        }

        public Builder balance(double value) {
            this.balance = value;
            return this;
        }

        public Builder status(String value) {
            this.status = value;
            return this;
        }

        public Builder subscription(Subscription value) {
            this.subscription = value;
            return this;
        }

        public Builder copy(AccountResource value) {
            this.accountNumber = value.getAccountNumber();
            this.status = value.getStatus();
            this.balance = value.getBalance();
            this.subscription = value.getSubscription();
            return this;
        }
        
        public AccountResource build(){
            return new AccountResource(this);
        }
    }
}
