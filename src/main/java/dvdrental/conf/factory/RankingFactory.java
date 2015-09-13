/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dvdrental.conf.factory;

import dvdrental.domain.Ranking;

/**
 *
 * @author bulelani
 */
public class RankingFactory {
  public static Ranking createRank(int rank){
      
      Ranking ranking  = new Ranking
              .Builder(rank)
              .build();
      return ranking;
  }  
}
