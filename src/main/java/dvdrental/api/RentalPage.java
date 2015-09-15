/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdrental.api;

import dvdrental.domain.Rental;
import dvdrental.model.RentalResource;
import dvdrental.services.RentalService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bulelani
 */
@RestController
@RequestMapping(value="/rental/**")
public class RentalPage {
    @Autowired
    private RentalService service;
    
    @RequestMapping(value = "/rentals", method = RequestMethod.GET)
    public List<RentalResource> getRentals(){
        List<RentalResource> hateos = new ArrayList<>();
        List<Rental> rentals = service.getAllRentals();
        for(Rental rental : rentals){
            RentalResource resource = new RentalResource
                    .Builder(rental.getRentalDate())
                    .dueDate(rental.getDueDate())
                    .fine(rental.getFine())
                    .returnDate(rental.getReturnDate())
                    .rentid(rental.getId())
                    .build();
            Link rents = new 
                Link("http://localhost:8080/rental/"+resource.getRentid().toString())
                    .withRel("rent");
            resource.add(rents);
            hateos.add(resource);
        }
        return hateos;
    }
    
    @RequestMapping(value = "/rentalbydates", method = RequestMethod.GET)
    public List<Rental> getRentalByDates(@RequestParam(value =  "rentalDate", defaultValue = "13-sep-2015") String rdate){
        return service.getRentalByDate(rdate);
    }
}
