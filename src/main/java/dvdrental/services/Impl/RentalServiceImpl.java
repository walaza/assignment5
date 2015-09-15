/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdrental.services.Impl;

import dvdrental.domain.Rental;
import dvdrental.repository.RentalRepository;
import dvdrental.services.RentalService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bulelani
 */
@Service
public class RentalServiceImpl implements RentalService {

    @Autowired
    RentalRepository repository;

    @Override
    public List<Rental> getAllRentals() {
        List<Rental> allrentals = new ArrayList<>();

        Iterable<Rental> rentals = repository.findAll();
        for (Rental rental : rentals) {
            allrentals.add(rental);
        }
        return allrentals;
    }

    @Override
    public List<Rental> getRentalByDate(String rdate) {
        List<Rental> rent = new ArrayList<>();
        Rental r = null;

        for (Rental re : rent) {
            if (re.getRentalDate().equals(r)) {
                r = re;
            }
            break;
        }
        if (r == null) {
            System.out.print("No data found");
        }
        return (List<Rental>) r;
    }

}
