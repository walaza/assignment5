/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdrental.domain;

import javax.persistence.Embeddable;

/**
 *
 * @author bulelani
 */
@Embeddable
public class ContactDetails {

    private String cellNumber;
    private String homeNumber;

    private ContactDetails() {
    }

    public ContactDetails(Builder builder) {
        cellNumber = builder.cellNumber;
        homeNumber = builder.homeNumber;
    }

    public static class Builder {

        private String cellNumber;
        private String homeNumber;

        public Builder(String cellNumber) {
            this.cellNumber = cellNumber;
        }

        public Builder homeNumber(String value) {
            this.homeNumber = value;
            return this;
        }

        public Builder copy(ContactDetails value) {
            this.cellNumber = value.getCellnumber();
            this.homeNumber = value.getHomeNumber();
            return this;
        }

        public ContactDetails build() {
            return new ContactDetails(this);
        }
    }

    public String getCellnumber() {
        return cellNumber;
    }

    public String getHomeNumber() {
        return homeNumber;
    }
}
