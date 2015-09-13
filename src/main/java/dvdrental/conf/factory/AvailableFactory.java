/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dvdrental.conf.factory;

import dvdrental.domain.AvailableDVD;

/**
 * 
 * @author bulelani
 */
public class AvailableFactory {
    public static AvailableDVD createAvailableDVD(String title, boolean available){
       
        AvailableDVD availabledvd = new AvailableDVD
                .Builder(title)
                .build();
        return availabledvd;
    }
}
