/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dvdRental.domain;

import dvdrental.conf.factory.RentalFactory;
import dvdrental.domain.Rental;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

/**
 *
 * @author bulelani
 */
public class RentalTest {
    
    public RentalTest() {
    }
    
    @Before
    public void setUp() {
    }
    @org.testng.annotations.Test
    public void createRental(){
        Rental rent = RentalFactory
                .createRental("5/6/2015", "5/7/2015", null, 0.00);
        Assert.assertEquals("5/6/2015", rent.getRentalDate());
    }
    @org.testng.annotations.Test
    public void updateRental(){
        Rental rent = RentalFactory
                .createRental("5/6/2015", "5/7/2015", null, 0.00);
        
        Rental rentcopy = RentalFactory
                .createRental("5/6/2015", "5/7/2015", "7/7/2015", 25.00);
        
        Assert.assertEquals("5/6/2015", rent.getRentalDate());
        Assert.assertEquals("5/6/2015", rentcopy.getRentalDate());
        Assert.assertEquals("5/7/2015", rent.getDueDate());
        Assert.assertEquals("5/7/2015", rentcopy.getDueDate());
        Assert.assertNull(rent.getReturnDate());
        Assert.assertEquals("7/7/2015", rentcopy.getReturnDate());
        
    }
}
