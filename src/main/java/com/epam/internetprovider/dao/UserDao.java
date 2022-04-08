package com.epam.internetprovider.dao;

import com.epam.internetprovider.entity.User;
import com.epam.internetprovider.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException;
    void topUpBalance(User user) throws DaoException;
    void changeName(User user) throws DaoException;
    List<User> getAll() throws DaoException;
}
