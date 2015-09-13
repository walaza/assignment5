/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dvdRental.service;

import dvdrental.App;
import dvdrental.conf.factory.DVDFactory;
import dvdrental.conf.factory.GenreFactory;
import dvdrental.conf.factory.RankingFactory;
import dvdrental.domain.DVD;
import dvdrental.domain.Genre;
import dvdrental.domain.Ranking;
import dvdrental.repository.DVDRepository;
import dvdrental.services.DVDService;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;

/**
 *
 * @author bulelani
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class DVDServiceTest extends AbstractTestNGSpringContextTests{
    @Autowired
    private DVDService service;
    private Long id;
    
    @Autowired
    private DVDRepository repository;
    private List<Genre> genres;
    @BeforeMethod
    public void setUp() throws Exception {
        genres = new ArrayList<Genre>();
    }
    @org.testng.annotations.Test
    public void create() throws Exception{
        Genre genre = GenreFactory
                .createGenre("The matrix", "horror", null);
        Ranking rank = RankingFactory
                .createRank(1);
 
        Genre genre1 = GenreFactory
                .createGenre("Suits", "Comedy", null);

        genres.add(genre);
        genres.add(genre1);
        
        DVD dvd = DVDFactory
                .createDVD("The matrix", 5, "2015", 35.00, rank, genres);
        
        repository.save(dvd);
        id = dvd.getId();
        Assert.assertNotNull(dvd.getId());
    }
    @org.testng.annotations.Test
    public void testGetDVD() throws Exception{
            List<DVD> dvd = service.getDVD();
            Assert.assertTrue(dvd.size() == 1);
    }
}
