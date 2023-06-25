package com.epam.internetprovider.dao;

import com.epam.internetprovider.entity.Tariff;
import com.epam.internetprovider.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface TariffDao {
    void updateDeletedStatus(Long id, Boolean status) throws DaoException;
    Optional<Tariff> getById(Long id) throws DaoException;
    List<Tariff> getAll() throws DaoException;
}
