package com.epam.internetprovider.dao;

import com.epam.internetprovider.entity.User;
import com.epam.internetprovider.exception.DaoException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface UserDao {
    Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException;
    void updateUserBlockedStatus (Long id, Boolean status) throws DaoException;
    void topUpBalance(Long id, BigDecimal amount) throws DaoException;
    void changePersonalData(Long id, String name, String surname) throws DaoException;
    void changeUserTariff(Long tariffId, Long userId) throws DaoException;
    void registerUser (String login, String password, String name, String surname) throws DaoException;
    List<User> getAll() throws DaoException;
    Optional<User> getById(Long id) throws DaoException;
}
