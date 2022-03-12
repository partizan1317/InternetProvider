package com.epam.internetprovider.dao;

import com.epam.internetprovider.entity.Identifiable;
import com.epam.internetprovider.exception.DaoException;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

//CRUD Create Read Update Delete
public interface Dao<T extends Identifiable> {

    Optional<T> getById(Long id) throws DaoException;

    List<T> getAll() throws DaoException;

    void save(T item) throws DaoException;

    void removeById(Long id) throws SQLException;
}
