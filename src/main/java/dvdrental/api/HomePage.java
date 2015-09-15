/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdrental.api;

import dvdrental.domain.DVD;
import dvdrental.services.DVDService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bulelani
 */
@RestController
@RequestMapping("/api/**")
public class HomePage {

    @Autowired
    private DVDService service;

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String Index() {
        return "This is a Home Page";
    }
    
    @RequestMapping(value = "/dvd",method = RequestMethod.GET)
    public DVD getMovie(){
        DVD dvd = new DVD.Builder("Breaking bad")
                .price(100.00).noOfCopies(10)
                .yearReleased("2013")
                .build();
        return dvd;
    }
    
    @RequestMapping(value = "dvds",method = RequestMethod.GET)
    public List<DVD> getDVD(){
        return service.getDVD();
    }
}

