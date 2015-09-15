/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdRental.service;

import dvdrental.App;
import dvdrental.conf.factory.RentalFactory;
import dvdrental.domain.Rental;
import dvdrental.repository.RentalRepository;
import dvdrental.services.RentalService;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 *
 * @author bulelani
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class RentalServiceTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private RentalService service;
    private Long id;
    
    @Autowired
    private RentalRepository repository;
    public RentalServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

     @org.testng.annotations.Test
     public void create(){
         Rental rent = RentalFactory
                 .createRental("13-sep-2015", "16-sep-2015", null, 0.00);
         
         repository.save(rent);
         id = rent.getId();
         Assert.assertNotNull(rent.getId());
     }
     
     @org.testng.annotations.Test
     public void testGetAllRentals() throws Exception{
         List<Rental> rent = service.getAllRentals();
         Assert.assertEquals(rent.size(), 2);
     }
     
     @org.testng.annotations.Test
     public void testGetRentalsByDate() throws Exception{
         List<Rental> rent = service.getRentalByDate("13-sep-2015");
         Assert.assertNull(rent);
     }
}
