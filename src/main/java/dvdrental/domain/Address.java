/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdrental.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author bulelani
 */
@Embeddable
public class Address implements Serializable {

    private String StreetName;
    private int code;
    private String postalAddress;

    private Address() {
    }

    public Address(Builder builder) {
        StreetName = builder.StreetName;
        code = builder.code;
        postalAddress = builder.postalAddress;
    }

    public static class Builder {

        private String StreetName;
        private int code;
        private String postalAddress;

        public Builder(String StreetName) {
            this.StreetName = StreetName;
        }

        public Builder code(int value) {
            this.code = value;
            return this;
        }

        public Builder postalAddress(String value) {
            this.postalAddress = value;
            return this;
        }

        public Builder copy(Address value) {
            StreetName = value.getStreetName();
            code = value.getCode();
            postalAddress = value.getPostalAddress();
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }

    public String getStreetName() {
        return StreetName;
    }

    public int getCode() {
        return code;
    }

    public String getPostalAddress() {
        return postalAddress;
    }
}
