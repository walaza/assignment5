/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dvdrental.repository;

import dvdrental.domain.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author bulelani
 */
public interface CustomerRepository extends CrudRepository<Customer, Long>{
    
}
