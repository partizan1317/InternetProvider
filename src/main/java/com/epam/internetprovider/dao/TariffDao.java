package com.epam.internetprovider.dao;

import com.epam.internetprovider.entity.Tariff;
import com.epam.internetprovider.exception.DaoException;

import java.util.Optional;

public interface TariffDao {
    Optional<Tariff> getById(Long id) throws DaoException;
}
