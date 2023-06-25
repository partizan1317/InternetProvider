package com.epam.internetprovider.dao;

import com.epam.internetprovider.entity.Promotion;
import com.epam.internetprovider.exception.DaoException;

import java.util.Optional;

public interface PromotionDao {
    Optional<Promotion> getById(Long id) throws DaoException;
}
