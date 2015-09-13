/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdrental.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author bulelani
 */
@Entity
public class Rental implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String rentalDate;
    private String dueDate;
    private String returnDate;
    private double fine;

    private Rental() {
    }

    public Rental(Builder builder) {
        rentalDate = builder.rentalDate;
        dueDate = builder.dueDate;
        returnDate = builder.returnDate;
        fine = builder.fine;
    }

    public static class Builder {

        private String rentalDate;
        private String dueDate;
        private String returnDate;
        private double fine;

        public Builder(String rentalDate) {
            this.rentalDate = rentalDate;
        }

        public Builder dueDate(String value) {
            this.dueDate = value;
            return this;
        }

        public Builder returnDate(String value) {
            this.returnDate = value;
            return this;
        }

        public Builder fine(double value) {
            this.fine = value;
            return this;
        }

        public Builder copy(Rental value) {
            this.rentalDate = value.getRentalDate();
            this.dueDate = value.getDueDate();
            this.returnDate = value.getReturnDate();
            this.fine = value.getFine();
            return this;
        }

        public Rental build() {
            return new Rental(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getRentalDate() {
        return rentalDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public double getFine() {
        return fine;
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
        if (!(object instanceof Rental)) {
            return false;
        }
        Rental other = (Rental) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dvdrental.domain.Rental[ id=" + id + " ]";
    }

}
