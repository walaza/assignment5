/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dvdRental.domain;

import dvdrental.conf.factory.ContactFactory;
import dvdrental.domain.ContactDetails;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author bulelani
 */
public class ContactDetailsTest {
    @org.testng.annotations.Test
    public void testCreate() throws Exception{
        ContactDetails details = ContactFactory
                .createContact("0786030795", "0213627990");
        Assert.assertEquals("0786030795",details.getCellnumber());
    }
    @org.testng.annotations.Test
    public void testUpdate() throws Exception{
        ContactDetails details = ContactFactory
                .createContact("0786030795", "0213627990");
  
       ContactDetails copieddetails = new ContactDetails
                .Builder("0786030795").copy(details).homeNumber("0213651234").build();
        
        Assert.assertEquals("0786030795",details.getCellnumber());
        Assert.assertEquals("0786030795",copieddetails.getCellnumber());
        Assert.assertEquals("0213627990",details.getHomeNumber());
        Assert.assertEquals("0213651234",copieddetails.getHomeNumber());
    }
}
