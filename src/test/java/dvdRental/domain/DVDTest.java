/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdRental.domain;

import dvdrental.conf.factory.DVDFactory;
import dvdrental.conf.factory.RankingFactory;
import dvdrental.domain.DVD;
import dvdrental.domain.Ranking;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author bulelani
 */
public class DVDTest {

    public DVDTest() {
    }

    @Before
    public void setUp() {
    }

    @org.testng.annotations.Test
    public void createDVD() throws Exception {
        Ranking rank = RankingFactory
                .createRank(5);

        DVD dvd = DVDFactory
                .createDVD("devils double", 5, "2015", 50.00, rank, null);
        Assert.assertEquals("devils double", dvd.getTitle());

    }

    @org.testng.annotations.Test
    public void updateDVD() throws Exception {
        Ranking rank = RankingFactory
                .createRank(5);

        DVD dvd = DVDFactory
                .createDVD("devils double", 5, "2015", 50.00, rank, null);

        DVD dvdcopy = DVDFactory
                .createDVD("devils double", 6, "2016", 70.00, rank, null);
        
        Assert.assertEquals("devils double", dvd.getTitle());
        Assert.assertEquals("devils double", dvdcopy.getTitle());
        Assert.assertEquals(5, dvd.getNoOfCopies());
        Assert.assertEquals(6, dvdcopy.getNoOfCopies());
        Assert.assertEquals("2015", dvd.getYearReleased());
        Assert.assertEquals("2016", dvdcopy.getYearReleased());
        Assert.assertEquals(50.00, dvd.getPrice(), dvd.getPrice());
        Assert.assertEquals(70.00, dvdcopy.getPrice(), dvdcopy.getPrice());
    }
}
