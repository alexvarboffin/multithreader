package com.walhalla.boilerplate.domain.repository

import com.walhalla.boilerplate.domain.repository.base.Repository

/**
 * A sample repository with CRUD operations on a model.
 */
interface CrudRepository<T> : Repository {
    fun insert(model: T): Boolean

    fun update(model: T): Boolean

    fun get(id: Long): T?

    fun delete(model: T): Boolean

    fun query(): MutableList<T>?
}