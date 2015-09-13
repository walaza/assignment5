/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dvdRental.domain;

import dvdrental.conf.factory.AddressFactory;
import dvdrental.domain.Address;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author bulelani
 */
public class AddressTest {
 @org.testng.annotations.Test
 public void testCreate() throws Exception{
     Address address = AddressFactory
             .createAddress("Gqobhoka", 7784, "40317");
     Assert.assertEquals("Gqobhoka",address.getStreetName());
 }
@org.testng.annotations.Test
 public void testUpdate() throws Exception{
     Address address = AddressFactory
             .createAddress("Gqobhoka", 7784, "40317");
     
     Address copiedaddress = new Address
             .Builder("Gqobhoka").copy(address).postalAddress("44185").code(7785).build();
     
     Assert.assertEquals("Gqobhoka",address.getStreetName());
     Assert.assertEquals("Gqobhoka",copiedaddress.getStreetName());
     Assert.assertEquals("40317",address.getPostalAddress());
     Assert.assertEquals("44185",copiedaddress.getPostalAddress());
     Assert.assertEquals(7784, address.getCode());
     Assert.assertEquals(7785, copiedaddress.getCode());
 }
}
