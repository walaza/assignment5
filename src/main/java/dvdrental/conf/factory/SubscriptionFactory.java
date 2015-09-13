/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dvdrental.conf.factory;

import dvdrental.domain.Subscription;

/**
 *
 * @author bulelani
 */
public class SubscriptionFactory {
  public static Subscription createSubscription(String name, double fees){
     
     Subscription subscription = new Subscription
             .Builder(name)
             .monthlyFees(fees)
             .build();
     return subscription;
  }  
}
