/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dvdRental.domain;

import dvdrental.conf.factory.GenreFactory;
import dvdrental.domain.Genre;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

/**
 *
 * @author bulelani
 */
public class GenreTest {
    
    @Test
    public void testCreate() throws Exception{
        Genre genre = GenreFactory
                .createGenre("testGenre", "Genretest", "test");
        Assert.assertEquals("testGenre", genre.getTitle());
    }
    @Test
    public void testUpdate() throws Exception{
        Genre genre = GenreFactory
                .createGenre("testGenre", "Genretest", "test");
        Assert.assertEquals("testGenre", genre.getTitle());     
        
        Genre updatedgenre = new Genre
                .Builder("testGenre").copy(genre).comedy("gen").horror("tests").build();
        Assert.assertEquals("testGenre", genre.getTitle());
        Assert.assertEquals("testGenre", updatedgenre.getTitle());
        Assert.assertEquals("Genretest", genre.getHorror());
        Assert.assertEquals("gen", updatedgenre.getHorror());
        Assert.assertEquals("test", genre.getComedy());
        Assert.assertEquals("tests", updatedgenre.getComedy());
    }
}
