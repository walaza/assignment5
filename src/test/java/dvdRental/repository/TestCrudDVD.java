/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dvdRental.repository;

import dvdrental.App;
import dvdrental.conf.factory.DVDFactory;
import dvdrental.domain.DVD;
import dvdrental.domain.Genre;
import dvdrental.domain.Ranking;
import dvdrental.repository.DVDRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

/**
 *
 * @author bulelani
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudDVD extends AbstractTestNGSpringContextTests{
    private Long id;
    public TestCrudDVD() {
    }
    @Autowired
    DVDRepository repository;

     @org.testng.annotations.Test
     public void create() {
         List<Genre> gen = new ArrayList<>();
 
         Genre genre = new Genre.Builder("Action")
                 .build();
         gen.add(genre);
         Ranking rank = new Ranking.Builder(5)
                 .build();
         DVD dvd = DVDFactory
                 .createDVD("Fast n Furious7", 7, "2015",150.00, rank, gen);
        repository.save(dvd);
        id = dvd.getId();
        Assert.assertNotNull(dvd.getId());
    }

    @org.testng.annotations.Test(dependsOnMethods = "create")
    public void read() throws Exception{
        DVD dvd = repository.findOne(id);
        Assert.assertEquals("Fast n Furious7", dvd.getTitle());
    }
    
    @org.testng.annotations.Test(dependsOnMethods = "read")
    public void update() throws Exception{
        DVD dvd = repository.findOne(id);
        DVD newDVD = new DVD.Builder("How to get away with")
                .noOfCopies(7)
                .genre(null)
                .build();
        repository.save(newDVD);
        Assert.assertEquals("How to get away with", dvd.getTitle());
    }
    
    @org.testng.annotations.Test(dependsOnMethods = "update")
    public void testDelete() throws Exception{
        DVD dvd = repository.findOne(id);
        repository.delete(dvd);
        DVD newDVD = repository.findOne(id);
        Assert.assertNull(newDVD);
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
