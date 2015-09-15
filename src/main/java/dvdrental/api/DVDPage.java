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
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author bulelani
 */
@RestController
@RequestMapping("/api/**")
public class DVDPage {

    @Autowired
    private DVDService service;

    @RequestMapping(value = "/dvds/", method = RequestMethod.GET)
    public ResponseEntity<List<DVD>> listAllDVDs() {
        List<DVD> movies = service.getDVD();
        if (movies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<DVD>>(movies, HttpStatus.OK);
    }

    @RequestMapping(value = "/dvd/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DVD> getDVD(@PathVariable("id") long id) {
        System.out.println("Fetching DVD with id " + id);
        DVD dvd = service.findById(id);
        if (dvd == null) {
            System.out.println("DVD with id " + id + " not found");
            return new ResponseEntity<DVD>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<DVD>(dvd, HttpStatus.OK);
    }

    @RequestMapping(value = "/dvd/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createDVD(@RequestBody DVD dvd, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating DVD " + dvd.getTitle());
        service.save(dvd);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/dvd/{id}").buildAndExpand(dvd.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/dvd/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<DVD> updateDVD(@PathVariable("id") long id, @RequestBody DVD dvd) {
        System.out.println("Updating DVD " + id);

        DVD currentmovie = service.findById(id);
        if (currentmovie == null) {
            System.out.println("DVD with id " + id + " not found");
            return new ResponseEntity<DVD>(HttpStatus.NOT_FOUND);
        }
        
        DVD updatedmovie = new DVD
                .Builder(currentmovie.getTitle())
                .copy(currentmovie)
                .build();
        service.update(updatedmovie);
        return new ResponseEntity<DVD>(updatedmovie, HttpStatus.OK);
    }
    
     @RequestMapping(value = "/dvd/delete/{id}", method = RequestMethod.DELETE)
     public ResponseEntity<DVD> deleteDVD(@PathVariable("id") long id){
       System.out.println("Fetching & Deleting DVD with id " + id);  
       
       DVD dvd = service.findById(id);
       if(dvd == null){
           System.out.println("Unable to delete. DVD with id " + id + " not found");
            return new ResponseEntity<DVD>(HttpStatus.NOT_FOUND);
       }
       service.delete(dvd);
       return new ResponseEntity<DVD>(HttpStatus.NO_CONTENT);
     }
}

