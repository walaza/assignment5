/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dvdrental.conf.factory;

import dvdrental.domain.DVD;
import dvdrental.domain.Genre;
import dvdrental.domain.Ranking;
import java.util.List;

/** 
 *
 * @author bulelani
 */
public class DVDFactory {
  public static DVD createDVD(String title, int copies, String year,
          double price, Ranking rank, List<Genre> genre){
      
      DVD dvd = new DVD
              .Builder(title)
              .noOfCopies(copies)
              .yearReleased(year)
              .price(price)
              .ranking(rank)
              .genre(genre)
              .build();
      return dvd;
  }  
}
