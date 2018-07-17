package com.kodelabs.boilerplate.domain.repository;

import com.kodelabs.boilerplate.domain.model.UserModel;

/**
 * A sample repository with CRUD operations on a model.
 */
public interface Repository {

    boolean insert(UserModel model);

    boolean update(UserModel model);

    UserModel get(Object id);

    boolean delete(UserModel model);
}
