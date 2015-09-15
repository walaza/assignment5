/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dvdrental.services;

import dvdrental.domain.DVD;
import java.util.List;

/**
 *
 * @author bulelani
 */
public interface DVDService {
    DVD findById(Long id);
    DVD save(DVD entity);
    void delete(DVD entity);
    DVD update(DVD entity);
    List<DVD> getDVD();
    DVD getDVDByTitle(String title);
    DVD getDVDByYearReleased(String year);
}
