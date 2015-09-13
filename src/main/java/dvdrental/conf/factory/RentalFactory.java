/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dvdrental.conf.factory;

import dvdrental.domain.Rental;

/**
 *
 * @author bulelani
 */
public class RentalFactory {
    public static Rental createRental(String rentalDate, String dueDate, String returnDate, double fine){
      
        Rental rental = new Rental
                .Builder(rentalDate)
                .dueDate(dueDate)
                .returnDate(returnDate)
                .fine(fine)
                .build();
        return rental;
    }
}
