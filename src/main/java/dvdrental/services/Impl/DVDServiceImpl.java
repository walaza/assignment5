/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dvdrental.services.Impl;

import dvdrental.domain.DVD;
import dvdrental.repository.DVDRepository;
import dvdrental.services.DVDService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bulelani
 */
@Service
public class DVDServiceImpl implements DVDService{
    @Autowired
    DVDRepository repository;
    @Override
    public List<DVD> getDVD() {
        List<DVD> alldvds = new ArrayList<>();
        
        Iterable<DVD> dvds  = repository.findAll();
        for(DVD dvd : dvds){
            alldvds.add(dvd);
        }
        return alldvds;
    }
    
}
