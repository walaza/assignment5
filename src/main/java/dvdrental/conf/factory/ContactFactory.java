/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dvdrental.conf.factory;

import dvdrental.domain.ContactDetails;

/**
 * 
 * @author bulelani
 */
public class ContactFactory {
      public static ContactDetails createContact(String cellNumber,String homeNumber){

        ContactDetails details = new ContactDetails
                .Builder(cellNumber)
                .homeNumber(homeNumber)
                .build();
        return details;
    }
}