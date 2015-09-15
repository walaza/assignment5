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
public class DVDServiceImpl implements DVDService {

    @Autowired
    DVDRepository repository;

    @Override
    public DVD findById(Long id) {
        return repository.findOne(id);
    }
    @Override
    public DVD save(DVD entity){
        return repository.save(entity);
    }
    @Override
    public void delete(DVD entity){
        repository.delete(entity);
    }
    
    @Override
    public DVD update(DVD entity) {
        return repository.save(entity);
    }
    
    @Override
    public List<DVD> getDVD() {
        List<DVD> alldvds = new ArrayList<>();

        Iterable<DVD> dvds = repository.findAll();
        for (DVD dvd : dvds) {
            alldvds.add(dvd);
        }
        return alldvds;
    }

    @Override
    public DVD getDVDByTitle(String title) {
        List<DVD> movies = new ArrayList<>();
        DVD res = null;
        movies = getDVD();

        for (DVD dvd : movies) {
            if (dvd.getTitle().contains(title)) {
                res = dvd;
            }
            break;
        }
        if (res == null) {
            System.out.print("Sorry no dvd found");
        }
        return res;
    }

    @Override
    public DVD getDVDByYearReleased(String year) {
        List<DVD> dvd = new ArrayList<>();
        DVD results = null;
        dvd = getDVD();

        for (DVD d : dvd) {
            if (d.getYearReleased().contains(year)) {
                results = d;
            }
            break;
        }
        if (results == null) {
            System.out.print("Sorry no dvd found");
        }
        return results;
    }
}

