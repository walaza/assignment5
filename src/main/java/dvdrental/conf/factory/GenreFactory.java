/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dvdrental.conf.factory;

import dvdrental.domain.Genre;

/**
 * 
 * @author bulelani
 */
public class GenreFactory {
  public static Genre createGenre(String title, String horror, String comedy){
   
      Genre genre = new Genre
              .Builder(title)
              .comedy(comedy)
              .horror(horror)
              .build();
      return genre;
  }  
}
