/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdrental.model;

import org.springframework.hateoas.ResourceSupport;

/*
 *
 * @author bulelani
 */
public class RentalResource extends ResourceSupport {

    private Long rentid;
    private String rentalDate;
    private String dueDate;
    private String returnDate;
    private double fine;

    private RentalResource() {

    }

    public Long getRentid() {
        return rentid;
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

    public String getRentalDate() {
        return rentalDate;
    }

    public RentalResource(Builder builder) {
        this.rentid = builder.rentid;
        this.dueDate = builder.dueDate;
        this.fine = builder.fine;
        this.rentalDate = builder.rentalDate;
        this.returnDate = builder.returnDate;
    }

    public static class Builder {

        private Long rentid;
        private String dueDate;
        private double fine;
        private String rentalDate;
        private String returnDate;

        public Builder(String rentalDate) {
            this.rentalDate = rentalDate;
        }

        public Builder dueDate(String value) {
            this.dueDate = value;
            return this;
        }

        public Builder rentid(Long value) {
            this.rentid = value;
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

        public Builder copy(RentalResource value) {
            this.rentalDate = value.getRentalDate();
            this.dueDate = value.getDueDate();
            this.returnDate = value.getReturnDate();
            this.fine = value.getFine();
            return this;
        }

        public RentalResource build() {
            return new RentalResource(this);
        }
    }
}
