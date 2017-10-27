package com.pizza.project.dao;
/*
* Main crud method
* */
public interface CrudDao<T> {
    T get(Long id);
    Long create(T object);
    Long update(T object);
    Long remove(Long id);
}
