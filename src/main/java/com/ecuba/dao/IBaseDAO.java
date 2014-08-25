/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ecuba.dao;

import org.springframework.dao.DataAccessException;

import java.io.Serializable;
import java.util.List;
/**
 * @author Wanted (Alien GR).
 * @author Rolando Bermúdez.
 */
public interface IBaseDAO<T, ID extends Serializable> {

    public T findById(ID id);

    public T findByIdLock(ID id) throws DataAccessException;

    public void remove(T entity);

    public T saveOrUpdate(T entity);

    public Integer countAll();

    public List<T> findAll() throws DataAccessException;

    public List<T> findAllCache() throws DataAccessException;

    public List<T> findByExample(final T exampleInstance,
                                 final String... excludeProperty) throws DataAccessException;

    public List<T> findPaginatedQuery(final Integer startIndex, final Integer cantidad, final String query,
                                      final Object... parametersValues) throws DataAccessException;
}
