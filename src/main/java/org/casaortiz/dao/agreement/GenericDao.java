package org.casaortiz.dao.agreement;

import java.util.List;
import java.util.Optional;
/**
 * Interface Generic for CRUD Basics
 * @author Ing. Jorge Ortiz
 * @version 06/30/2022
 * @see <a href= "https://jorgeortizc06.github.io">Portafolio </a>
 */
public interface GenericDao<T> {
    /**
     * @param isInsert true: save, false: update
     */
    T save(T item, boolean isInsert) throws Exception;

    Optional<T> findById(int id) throws Exception;

    void deleteById(int id) throws Exception;

    List<T> findAll() throws Exception;

    List<T> findCategoryByName(String name) throws Exception;

}
