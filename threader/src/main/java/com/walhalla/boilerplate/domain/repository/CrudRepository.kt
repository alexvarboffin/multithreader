package com.walhalla.boilerplate.domain.repository;

import com.walhalla.boilerplate.domain.repository.base.Repository;

import java.util.List;

/**
 * A sample repository with CRUD operations on a model.
 */
public interface CrudRepository<T> extends Repository {

    boolean insert(T model);

    boolean update(T model);

    T get(long id);

    boolean delete(T model);

    List<T> query();
}