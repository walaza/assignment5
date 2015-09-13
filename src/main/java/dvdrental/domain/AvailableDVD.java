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
public class AvailableDVD {

    private String title;
    private boolean available;

    private AvailableDVD() {
    }

    public AvailableDVD(Builder builder) {
        title = builder.title;
        available = builder.available;
    }

    public static class Builder {

        private String title;
        private boolean available;

        public Builder(String title) {
            this.title = title;
        }

        public Builder copy(AvailableDVD value) {
            title = value.getTitle();
            available = value.isAvailable();
            return this;
        }
        
        public AvailableDVD build() {
            return new AvailableDVD(this);
        }
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }
}
