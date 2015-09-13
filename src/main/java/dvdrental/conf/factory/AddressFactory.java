/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dvdrental.conf.factory;

import dvdrental.domain.Address;

/**
 * 
 * @author bulelani
 */
public class AddressFactory {
   public static Address createAddress(String StreetName, int code, String postalAddress){
      
       Address address = new Address
               .Builder(StreetName)
               .postalAddress(postalAddress)
               .code(code)
               .build();
       return address;
   }
}
